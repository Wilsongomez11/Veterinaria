class ConsultaMedica(
    private val mascota: Mascota,
    private val diagnostico: String,
    private val costoBase: Double,
    private val incluyeMedicacion: Boolean
) : Mascota(mascota.nombre, mascota.especie, mascota.edad, mascota.peso) {

    fun calcularCosto(): Double {
        return if (incluyeMedicacion) costoBase * 1.15 else costoBase
    }

    override fun describirMascota(): String {
        return super.describirMascota() + ", Diagnóstico: $diagnostico, Costo: ${calcularCosto()}"
    }
}