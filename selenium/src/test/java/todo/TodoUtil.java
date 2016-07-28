package todo;

import static support.Browser.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TodoUtil {
	public static void addTodo(String text) {
		any("#new-todo").sendKeys(text + "\n");
	}

	public static WebElement todoAt(int index) {
		return todoAt(index, false);
	}

	public static WebElement todoAt(int index, boolean immediate) {
		String selector = "#todo-list li:nth-child(" + (index + 1) + ")";
		return immediate ? anyImmediate(selector) : any(selector);
	}

	public static void markTodoDone(WebElement todo) {
		any(todo, "input.check").click();
	}

	public static boolean isDone(WebElement todo) {
		return anyImmediate(todo, ".todo.done") != null;
	}

	public static void deleteTodo(WebElement todo) {
		new Actions(browser).moveToElement(todo).moveToElement(any(todo, ".todo-destroy")).click().build().perform();
	}

	public static void clearDoneTodos() {
		any(".todo-clear").click();
	}
}
