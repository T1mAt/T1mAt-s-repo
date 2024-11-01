package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String home() {
        return """
                <html>
                <body>
                    <form action="/calculate" method="get">
                        <label>Enter expression:</label>
                        <input type="text" name="expression" />
                        <button type="submit">Calculate</button>
                    </form>
                </body>
                </html>
                """;
    }

    @RequestMapping("/calculate")
    public String calculate(@RequestParam String expression) {
        try {
            Expression exp = new ExpressionBuilder(expression).build();
            double result = exp.evaluate();
            return "Result: " + result;
        } catch (Exception e) {
            return "Invalid expression. Please enter a valid mathematical expression.";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}