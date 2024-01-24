fun main() {
    println("Hello, Kotlin/Native!")
    val driver: SqlDriver = NativeSqliteDriver(Database.Schema, "test.db")
    doDatabaseThings(driver)
}

fun doDatabaseThings(driver: SqlDriver) {
    val database = Database(driver)
    val playerQueries: PlayerQueries = database.playerQueries

    println(playerQueries.selectAll().executeAsList())
    // [HockeyPlayer(15, "Ryan Getzlaf")]

    playerQueries.insert(player_number = 10, full_name = "Corey Perry")
    println(playerQueries.selectAll().executeAsList())
    // [HockeyPlayer(15, "Ryan Getzlaf"), HockeyPlayer(10, "Corey Perry")]

    val player = HockeyPlayer(10, "Ronald McDonald")
    playerQueries.insertFullPlayerObject(player)
}