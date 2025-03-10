class GestionVeterinaria {
    private val mascotas = mutableListOf<Mascota>()
    private val consultas = mutableListOf<ConsultaMedica>()

    fun agregarMascota(mascota: Mascota) {
        mascotas.add(mascota)
    }

    fun registrarConsulta(mascota: Mascota, diagnostico: String, costoBase: Double, incluyeMedicacion: Boolean) {
        val consulta = ConsultaMedica(mascota, diagnostico, costoBase, incluyeMedicacion)
        consultas.add(consulta)
    }

    fun mostrarHistorial(mascota: Mascota) {
        println("\nHistorial de consultas para ${mascota.nombre}:")
        consultas.filter { it.nombre == mascota.nombre }.forEach {
            println("\ud83d\udd39 ${it.describirMascota()}")
        }
    }

    fun calcularCostoTotal(mascota: Mascota): Double {
        return consultas.filter { it.nombre == mascota.nombre }.sumOf { it.calcularCosto() }
    }

    fun buscarMascota(nombre: String): Mascota? {
        return mascotas.find { it.nombre.equals(nombre, ignoreCase = true) }
    }
}


