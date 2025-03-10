import java.util.Scanner
fun main() {
    val scanner = Scanner(System.`in`)
    val sistema = GestionVeterinaria()

    while (true) {
        println("\nSistema de Gestión Veterinaria ")
        println("1. Registrar Mascota")
        println("2. Registrar Consulta Médica")
        println("3. Mostrar Historial de Consultas")
        println("4. Modificar Peso de Mascota")
        println("5. Incrementar Edad de Mascota")
        println("6. Calcular Costo Total de Consultas")
        println("7. Salir")
        print("Seleccione una opción: ")

        when (scanner.nextInt()) {
            1 -> {
                print("Ingrese nombre de la mascota: ")
                val nombre = scanner.next()
                print("Ingrese especie: ")
                val especie = scanner.next()
                print("Ingrese edad: ")
                val edad = scanner.nextInt()
                print("Ingrese peso: ")
                val peso = scanner.nextDouble()
                sistema.agregarMascota(Mascota(nombre, especie, edad, peso))
                println("Mascota registrada con éxito")
            }
            2 -> {
                print("Ingrese nombre de la mascota: ")
                val nombre = scanner.next()
                val mascota = sistema.buscarMascota(nombre)
                if (mascota != null) {
                    print("Ingrese diagnóstico: ")
                    val diagnostico = scanner.next()
                    print("Ingrese costo base: ")
                    val costoBase = scanner.nextDouble()
                    print("¿Incluye medicación? (true/false): ")
                    val incluyeMedicacion = scanner.nextBoolean()
                    sistema.registrarConsulta(mascota, diagnostico, costoBase, incluyeMedicacion)
                    println("Consulta registrada")
                } else {
                    println("Mascota no encontrada")
                }
            }
            3 -> {
                print("Ingrese nombre de la mascota: ")
                val nombre = scanner.next()
                val mascota = sistema.buscarMascota(nombre)
                if (mascota != null) {
                    sistema.mostrarHistorial(mascota)
                } else {
                    println("Mascota no encontrada")
                }
            }
            4 -> {
                print("Ingrese nombre de la mascota: ")
                val nombre = scanner.next()
                val mascota = sistema.buscarMascota(nombre)
                if (mascota != null) {
                    print("Ingrese nuevo peso: ")
                    val nuevoPeso = scanner.nextDouble()
                    mascota.actualizarPeso(nuevoPeso)
                    println("Peso actualizado correctamente")
                } else {
                    println("Mascota no encontrada")
                }
            }
            5 -> {
                print("Ingrese nombre de la mascota: ")
                val nombre = scanner.next()
                val mascota = sistema.buscarMascota(nombre)
                if (mascota != null) {
                    mascota.incrementarEdad()
                    println("Edad incrementada en 1 año")
                } else {
                    println("Mascota no encontrada")
                }
            }
            6 -> {
                print("Ingrese nombre de la mascota: ")
                val nombre = scanner.next()
                val mascota = sistema.buscarMascota(nombre)
                if (mascota != null) {
                    println("Costo total de consultas: ${sistema.calcularCostoTotal(mascota)}")
                } else {
                    println("Mascota no encontrada")
                }
            }
            7 -> {
                println("terminado")
                break
            }
            else -> println("Opción inválida. Intente de nuevo")
        }
    }
}


        
