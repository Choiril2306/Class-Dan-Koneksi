package com.example.classdankoleksi

// Tugas 1
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart, // Menggunakan Daypart enum
    val durationInMinutes: Int,
)

// Tugas 2
enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING
}

val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

fun main() {
    // Menambahkan 9 event dengan pembagian yang sesuai
    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 10)
    val event2 = Event(title = "Shower", daypart = Daypart.MORNING, durationInMinutes = 20)
    val event3 = Event(title = "Get ready", daypart = Daypart.MORNING, durationInMinutes = 20)
    val event4 = Event(title = "Commute to Campus", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
    val event5 = Event(title = "Learn and practice Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 180)
    val event6 = Event(title = "Lunch Break", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
    val event7 = Event(title = "Self-Study", daypart = Daypart.AFTERNOON, durationInMinutes = 180)
    val event8 = Event(title = "Relaxation Time", daypart = Daypart.EVENING, durationInMinutes = 30)
    val event9 = Event(title = "Bedtime", daypart = Daypart.EVENING, durationInMinutes = 360)

    val events = mutableListOf(event1, event2, event3, event4, event5, event6, event7, event8, event9)

    // Menampilkan semua events
    events.forEach { println(it) }

    // Menghitung jumlah short events
    val shortEvents = events.filter { it.durationInMinutes < 60 }
    println("You have ${shortEvents.size} short events.")

    // Mengelompokkan events berdasarkan daypart
    val groupedEvents = events.groupBy { it.daypart }
    groupedEvents.forEach { (daypart, events) ->
        println("$daypart: ${events.size} events")
    }

    // Menampilkan event terakhir dalam daftar
    println("Last event of the day: ${events.last().title}")

    // Menampilkan durasi event pertama dalam daftar
    println("Duration of first event of the day: ${events[0].durationOfEvent}")
}
