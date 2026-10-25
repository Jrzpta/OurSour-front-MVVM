package cl.oursour.app.model.domain

// ---------------------------------------------------------------------------
// Constantes de dominio (evitan "strings mágicos" repartidos por el código)
// ---------------------------------------------------------------------------



object Roles {
    const val CONSUMER = "CONSUMER"
    const val ADMIN = "ADMIN"
}

object Categories {
    const val DESTILADO = "DESTILADO"
    const val LICOR = "LICOR"
    const val JUGO = "JUGO"
    const val FRUTA = "FRUTA"

    val all = listOf(DESTILADO, LICOR, JUGO, FRUTA)

    fun label(category: String): String = when (category) {
        DESTILADO -> "Destilados"
        LICOR -> "Licores"
        JUGO -> "Jugos y bebidas"
        FRUTA -> "Frutas y hierbas"
        else -> category
    }

    fun emoji(category: String): String = when (category) {
        DESTILADO -> "🥃"
        LICOR -> "🍸"
        JUGO -> "🧃"
        FRUTA -> "🍋"
        else -> "🍹"
    }
}

object OrderStatus {
    const val EN_PREPARACION = "En preparación"
    const val SOLICITADO = "Solicitado"
}

object LogType {
    const val INGREDIENT = "INGREDIENT"
    const val RECIPE = "RECIPE"
}
