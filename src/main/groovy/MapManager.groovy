import groovy.json.JsonSlurper

class MapManager {

    public Map faceMap

    MapManager() {

        String fpath

        def slurp = new JsonSlurper()

        try {
            fpath = getClass().getResource("faces.json").getFile()
        } catch (e) {
            throw e
        }

        def file = new File(fpath)

        try {
            faceMap = slurp.parse(file) as Map
        } catch (e) {
            throw e
        }

    }


}
