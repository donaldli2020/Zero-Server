package Zero

import Zero.Main.Companion.xResp
import Zero.api.*

object Runner {

    var mappings: Mappings? = Mappings()
    var PORT = 80


    fun main () {


        mappings!!.addMap("GET", "/", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {
                return xResp
            }
        })



        // --------------------------------------------------
        // Server loop
        var server: Server
        while (1 == 1) {
            server = Server(PORT, mappings!!)
            val req = server.accept()
            server.sendResponse(req)
            server.shut()
        }
    }
}