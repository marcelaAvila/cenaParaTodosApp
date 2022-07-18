package com.ean.cenaparatodosapp

class DonacionesProvider {
    companion object{
        val donacionesList=  listOf<Donaciones>(

            Donaciones(
                "12/07/22",
                "Roberto Medez",
                50_000.0
            ),
            Donaciones(
                "02/05/22",
                "Lidis Borrero",
                500_700.0
            ),
            Donaciones(
                "29/08/22",
                "Roberto Medez",
                10_000.0
            )

        )
    }
}