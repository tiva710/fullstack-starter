package todo;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *  small web server that connects the frontend to the backend. 
 *
 * Run it, then open http://localhost:8080 in your browser.
 *
 * In a real project, a framework like Spring Boot does this job
 * and the tasks would come from a database instead of
 * being created in main().
 */
public class TaskServer {

    public static void main(String[] args) throws IOException {
        TaskList list = new TaskList();
        list.addTask("Learn Git branching");
        list.addTask("Write a meaningful test");
        list.addTask("Try a SQL query");
        list.completeTask("Learn Git branching");

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Frontend: send the web page to the browser
        server.createContext("/", exchange -> {
            byte[] page = Files.readAllBytes(Path.of("frontend/index.html"));
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=utf-8");
            exchange.sendResponseHeaders(200, page.length);
            try (OutputStream out = exchange.getResponseBody()) {
                out.write(page);
            }
        });

        // Backend: answer the browser's request for tasks with JSON
        server.createContext("/tasks", exchange -> {
            byte[] json = toJson(list).getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, json.length);
            try (OutputStream out = exchange.getResponseBody()) {
                out.write(json);
            }
        });

        server.start();
        System.out.println("Server running. Open http://localhost:8080");
    }

    /** Turns the task list into JSON text, like: [{"name":"task here","done":true}] */
    private static String toJson(TaskList list) {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < list.getTasks().size(); i++) {
            Task task = list.getTasks().get(i);
            if (i > 0) {
                json.append(",");
            }
            json.append("{\"name\":\"").append(task.getName().replace("\"", "\\\"")).append("\",\"done\":").append(task.isDone()).append("}");
        }
        return json.append("]").toString();
    }
}
