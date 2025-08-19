package com.orbit.clase1app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        tareaA11()
        setContent {
        }
    }
}


//Constantes Globales
const val APP_NAME ="Clase1App"
const val APP_VERSION="1.0.0"

fun tarea1(){

    //Variables con var
    var contador: Int=0
    var mensaje:String ="Hola"

    //Constantes con val
    val PI:Double =3.14159
    val DIAS_SEMANA:Int=7

    //Imprimimos los resultados en Logcat
    Log.d("A1","Nombre app: $APP_NAME")
    Log.d("A1","Version app: $APP_VERSION")
    Log.d("A1","$mensaje, contador=$contador")
    Log.d("A1","PI=$PI, dias=$DIAS_SEMANA")


}
fun tareaA2() {
    val edad: Int = 25
    val poblacion: Long = 33000000L
    val temperatura: Float = 23.5f
    val pi: Double = 3.1415926535

    Log.d("A2", "Edad (Int): $edad")
    Log.d("A2", "Población (Long): $poblacion")
    Log.d("A2", "Temperatura (Float): $temperatura")
    Log.d("A2", "PI (Double): $pi")
}

fun calificar(nota: Int): String {
    return if (nota >= 11) "Aprobado" else "Desaprobado"
}

fun tareaA3() {
    val notas = listOf(5, 10, 11, 15, 20)

    for (nota in notas) {
        val resultado = calificar(nota)
        Log.d("A3", "Nota: $nota → Resultado: $resultado")

    }
}

fun clasificarEdad(edad: Int): String {
    return when (edad) {
        in 0..12 -> "Niño"
        in 13..17 -> "Adolescente"
        in 18..59 -> "Adulto"
        else -> "Mayor"
    }
}

fun tareaA4() {
    val edades = listOf(5, 14, 30, 60, 80)

    for (edad in edades) {
        val categoria = clasificarEdad(edad)
        Log.d("A4", "Edad: $edad → Categoría: $categoria")
    }
}

fun tareaA5() {
    val numero = 5

    //Mi table con while
    var i = 1
    while (i <= 10) {
        Log.d("A5-while", "$numero x $i = ${numero * i}")
        i++
    }

    // Mi table con for
    for (j in 1..10) {
        Log.d("A5-for", "$numero x $j = ${numero * j}")
    }
}

data class Producto(val id: Int,
                    val nombre: String,
                    val precio: Double,
                    val stock: Int)

fun tareaA6() {
    val productos = listOf(
        Producto(1, "Laptop", 2500.0, 5),
        Producto(2, "Mouse", 50.0, 0),
        Producto(3, "Teclado", 120.0, 3),
        Producto(4, "Monitor", 800.0, 0),
        Producto(5, "USB", 30.0, 10)
    )

    val nombresDisponibles = productos.filter { it.stock > 0 }.map { it.nombre }
    val totalInventario = productos.sumOf { it.precio * it.stock }
    val sinStock = productos.count { it.stock == 0 }

    Log.d("A6", "Productos disponibles: $nombresDisponibles")
    Log.d("A6", "Valor total del inventario: $totalInventario")
    Log.d("A6", "Cantidad de productos sin stock: $sinStock")
}

fun aEnteroSeguro(s: String): Int {
    val convertido = s.toIntOrNull() ?: -1
    return convertido
}

fun tareaA7() {
    val entradas = listOf("123", "abc", "45", "", "9999")

    for (entrada in entradas) {
        val resultado = aEnteroSeguro(entrada)
        Log.d("A7", "Entrada: \"$entrada\" → Resultado: $resultado")
    }
}

fun esPrimo(n: Int): Boolean {
    if (n < 2) return false
    for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) return false
    }
    return true
}


fun fibonacci(n: Int): List<Int> {
    val lista = mutableListOf(0, 1)
    for (i in 2 until n) {
        lista.add(lista[i - 1] + lista[i - 2])
    }
    return lista
}

fun tareaA8() {
    val fibo = fibonacci(10)
    Log.d("A8", "Fibonacci(10): $fibo")

    val numeros = listOf(3, 7, 10)
    for (num in numeros) {
        val primo = esPrimo(num)
        Log.d("A8", "¿$num es primo? → $primo")
    }
}

class Persona(var nombre: String, var edad: Int) {
    fun cumplirAnios() {
        edad++
    }

    fun presentacion(): String {
        return "Hola, soy $nombre y tengo $edad años."
    }
}

data class Usuario(val nombre: String, val edad: Int)

fun tareaA9() {
    val persona = Persona("Luis", 30)
    persona.cumplirAnios()
    Log.d("A9", persona.presentacion())

    val usuario1 = Usuario("Ana", 25)
    val usuario2 = usuario1.copy(edad = 26)
    val sonIguales = usuario1 == usuario2

    Log.d("A9", "Usuario original: $usuario1")
    Log.d("A9", "Usuario modificado con copy: $usuario2")
    Log.d("A9", "¿Son iguales? → $sonIguales")
}

fun List<Int>.media(): Double {
    return if (this.isNotEmpty()) this.sum().toDouble() / this.size else 0.0
}

fun String.capitalizarPrimera(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}

fun tareaA10() {
    val numeros = listOf(10, 20, 30, 40, 50)
    val promedio = numeros.media()
    Log.d("A10", "Promedio de la lista: $promedio")

    val texto = "kotlin es genial"
    val capitalizado = texto.capitalizarPrimera()
    Log.d("A10", "Texto capitalizado: $capitalizado")
}

fun tareaA11() {
    val nums = (1..20).toList()

    val pares = nums.filter { it % 2 == 0 }
    val sumaPares = pares.sum()
    val promedioPares = pares.average()

    Log.d("A11", "Números pares: $pares")
    Log.d("A11", "Suma de pares: $sumaPares")
    Log.d("A11", "Promedio de pares: $promedioPares")
}






