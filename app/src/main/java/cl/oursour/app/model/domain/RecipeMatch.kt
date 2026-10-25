package cl.oursour.app.model.domain

import cl.oursour.app.model.entity.IngredientEntity
import cl.oursour.app.model.entity.ProductEntity
import cl.oursour.app.model.entity.RecipeEntity
import cl.oursour.app.util.MatchCalculator

/** Una receta junto con su producto Our Sour y qué tan compatible es con el usuario. */
data class RecipeMatch(
    val recipe: RecipeEntity,
    val product: ProductEntity?,
    val required: List<IngredientEntity>,
    val missing: List<IngredientEntity>
) {
    val ownedCount: Int get() = required.size - missing.size
    val percent: Int get() = MatchCalculator.percent(ownedCount, required.size)
    val steps: List<String> get() = recipe.steps.split("\n").filter { it.isNotBlank() }
}

/** Ordena de mayor a menor compatibilidad; a igualdad, las que menos ingredientes faltan. */
fun List<RecipeMatch>.rankedByRelevance(): List<RecipeMatch> =
    sortedWith(
        compareByDescending<RecipeMatch> { it.percent }
            .thenBy { it.missing.size }
            .thenBy { it.recipe.title }
    )
