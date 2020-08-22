import io.javalin.Javalin

def app = Javalin.create().start(3000)
def rootHandler = new PathHandler()

app.get("/", {ctx ->

    MapManager manager

    try {
        manager = new MapManager()
    } catch (ex) {
        ctx.status(500)
        println(ex)
        return
    }

    def set = manager ? manager.faceMap.keySet() : "None. (Internal Error)"
    ctx.result("Face generator. Available faces: ${set}\n")

})

app.get("/:name", rootHandler)
