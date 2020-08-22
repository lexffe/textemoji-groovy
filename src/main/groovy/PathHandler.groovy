import io.javalin.http.Context
import io.javalin.http.Handler
import org.jetbrains.annotations.NotNull

class PathHandler implements Handler {
    @Override
    void handle(@NotNull Context ctx) throws Exception {

        MapManager manager

        try {
            manager = new MapManager()
        } catch (ex) {
            ctx.status(500)
            println(ex)
            return
        }

        def facename = ctx.pathParam("name", String)
        String face

        try {
            face = manager.faceMap.get(facename.value)
        } catch (ex) {
            ctx.status(404)
            ctx.result("face not found")
            println(ex)
            return
        }

        ctx.result("${face ?: '???'}\n")
    }
}
