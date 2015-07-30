package org.fenixedu.demo.json;

import org.fenixedu.bennu.core.annotation.DefaultJsonAdapter;
import org.fenixedu.bennu.core.json.JsonAdapter;
import org.fenixedu.bennu.core.json.JsonBuilder;
import org.fenixedu.demo.domain.Todo;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@DefaultJsonAdapter(Todo.class)
public class TodoAdapter implements JsonAdapter<Todo> {

    @Override
    public Todo create(JsonElement el, JsonBuilder ctx) {

        final JsonObject json = el.getAsJsonObject();

        final String text = json.get("text").getAsString();

        return new Todo(text);

    }

    @Override
    public Todo update(JsonElement el, Todo todo, JsonBuilder ctx) {

        todo.toggle();

        return todo;

    }

    @Override
    public JsonElement view(Todo todo, JsonBuilder ctx) {

        JsonObject view = new JsonObject();

        view.addProperty("id", todo.getExternalId());

        view.addProperty("text", todo.getText());

        view.addProperty("done", todo.getCompleted() == null ? null : todo.getCompleted().toString());

        return view;

    }

}