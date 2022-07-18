package com.ean.cenaparatodosapp

class MovimientoProvider {
    companion object{
        val movimientos= listOf<Movimiento>(

            Movimiento(
                "12/07/22",
                "Retiro",
                20_000.0
            ),

            Movimiento(
                "25/07/22",
                "Retiro",
                450_000.0
            ),

            Movimiento(
                "17/07/22",
                "Ingreso",
                220_000.0
            ),
            Movimiento(
                "18/05/22",
                "Ingreso",
                150_000.0
            ),
            Movimiento(
                "29/06/22",
                "Ingreso",
                185_200.0
            )

        )
    }
}