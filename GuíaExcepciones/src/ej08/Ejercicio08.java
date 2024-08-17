package ej08;

public class Ejercicio08 {
	/*
	 * Explorar el uso de la palabra reservada assert para verificar ciertas
	 * condiciones durante la ejecución del código. Por ejemplo, que el dividendo
	 * sea diferente a cero en una división.
	 */

	/*
	 * La palabra reservada assert se utiliza en Java para realizar validaciones del
	 * código en tiempo de ejecución. Debes tener cuidado al utilizar assert puesto
	 * que si una evaluación falla se lanzará un Error (más grave que una
	 * Exception), específicamente un AssertionError y al suceder esto el programa,
	 * si el error no es controlado la aplicación (o hilo) será detenida. Por
	 * defecto, los asserts son ignorados por la JVM, puedes activarlos al agregar
	 * el parámetro -enableassertions o -ea. Como recomendación personal, sólo
	 * utiliza assert durante tiempo de debug o ejecución en entornos de desarrollo,
	 * no habilites la evaluación de asserts en producción. Importante: no confundir
	 * la palabra reservada assert con los métodos assertXyz de frameworks de
	 * pruebas como JUnit o TestNG, este último grupo cumplen una funcionalidad
	 * distinta.
	 * 
	 * Ahora, sobre si deberías siempre validar si la variable es null o no, es una
	 * cuestión de diseño. Puedes realizar lo que se llama programación defensiva,
	 * que es defender tu código de cualquier cosa que pueda afectarlo como validar
	 * si hay variables null y reemplazarlas con valores por defecto que no harán
	 * nada, o diseñar tu aplicación para que maneje los NullPointerException a un
	 * nivel superior al de tu método. Dependiendo de lo que realices, deberás
	 * elegir entre una u otra.
	 */

	/*
	 * Para habilitar assert:
	 * IntelliJ IDEA
	 * - Ve a Run > Edit Configurations.
	 * - Selecciona tu configuración de ejecución bajo Application.
	 * - En la sección VM options, añade -ea.
	 * - Guarda y ejecuta tu programa.
	 * 
	 * 
	 * Eclipse
	 * - Ve a Run > Run Configurations.
	 * - Selecciona tu configuración de ejecución bajo Java Application.
	 * - En la pestaña Arguments, en la sección VM arguments, añade -ea.
	 * - Guarda y ejecuta tu programa.
	 */
}
