package com.wyndhamjade.interview.test;

import com.wyndhamjade.interview.test.model.Assignee;
import com.wyndhamjade.interview.test.model.Task;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public final class TasksServlet extends HttpServlet {
    private DataSource dataSource;

    @Resource(name = "jdbc/dataSource")
    public void setDataSource(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            final List<Task> tasks = new LinkedList<Task>();

            conn = dataSource.getConnection();
            ps = conn.prepareStatement("" +
                    "select t.id, t.description, t.due, t.completed_at, " +
                    "       t.created_at as task_created_at, " +
                    "       t.assigned_to, a.name, a.email, " +
                    "       a.created_at as assignee_created_at " +
                    "  from tasks t " +
                    "  left outer join assignees a on t.assigned_to = a.id");
            rs = ps.executeQuery();

            while (rs.next()) {
                Assignee assignee = null;
                final long assigneeId = rs.getLong("assigned_to");
                if (!rs.wasNull()) {
                    assignee = new Assignee();
                    assignee.setId(assigneeId);
                    assignee.setName(rs.getString("name"));
                    assignee.setEmail(rs.getString("email"));
                    assignee.setCreatedAt(rs.getTimestamp("assignee_created_at"));
                }

                final Task task = new Task();
                task.setId(rs.getLong("id"));
                task.setDescription(rs.getString("description"));
                task.setDue(rs.getTimestamp("due"));
                task.setCompletedAt(rs.getTimestamp("completed_at"));
                task.setCreatedAt(rs.getTimestamp("task_created_at"));
                task.setAssignee(assignee);

                tasks.add(task);
            }

            request.setAttribute("tasks", tasks);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (final SQLException e) {
            throw new ServletException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (final SQLException ignored) {
                    // ignored
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (final SQLException ignored) {
                    // ignored
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (final SQLException ignored) {
                    // ignored
                }
            }
        }
    }
}
