# Traditional T9
Este manual explica cómo configurar y utilizar el T9 Tradicional en diferentes escenarios. Para obtener instrucciones de instalación e información sobre las versiones "lite" y "full", consulte la [Guía de Instalación](https://github.com/sspanak/tt9/blob/master/docs/installation.md) en GitHub. Finalmente, puede visitar la [página del repositorio principal](https://github.com/sspanak/tt9), que incluye todo el código fuente, una guía para desarrolladores, la política de privacidad y documentación complementaria.

## Configuración Inicial
Después de instalar, primero debe habilitar T9 Tradicional como teclado de Android. Para hacerlo, haga clic en el icono del lanzador. Si necesita realizar alguna acción, todas las opciones, excepto la Configuración Inicial, estarán deshabilitadas, y habrá una etiqueta: "TT9 está deshabilitado". Vaya a Configuración Inicial y habilítelo.

_Si no ve el icono justo después de la instalación, reinicie su teléfono, y debería aparecer. Esto se debe a que Android intenta ahorrar batería al no actualizar la lista de aplicaciones recién instaladas._

### Uso en un teléfono solo con pantalla táctil
En los dispositivos con pantalla táctil, también se recomienda deshabilitar el corrector ortográfico del sistema. No se puede usar cuando se escribe con las teclas numéricas, por lo que puede ahorrar algo de batería al desactivarlo.

Otro problema es que puede mostrar un cuadro de diálogo confuso de "Agregar palabra", que agrega palabras al teclado predeterminado del sistema (generalmente Gboard) y no al diccionario de T9 Tradicional. De nuevo, para evitar tales situaciones, debe deshabilitarse el corrector ortográfico del sistema.

Si necesita realizar este paso, el elemento "Corrector Ortográfico del Sistema" en la pantalla de Configuración Inicial estará activo. Haga clic en él para deshabilitar el componente del sistema. Si no aparece ese elemento, entonces no necesita hacer nada más.

Una vez que haya terminado con la configuración, consulte la sección [Teclado en pantalla](#teclado-en-pantalla) para obtener más consejos y trucos.

### Habilitar el Modo Predictivo
El Modo Predictivo requiere que se cargue un diccionario de idioma para ofrecer sugerencias de palabras. Puede activar o desactivar los idiomas habilitados y cargar sus diccionarios desde la Pantalla de Configuración → [Idiomas](#opciones-de-idioma). En caso de que olvide cargar algún diccionario, T9 Tradicional lo hará automáticamente cuando empiece a escribir. Para más información, [consulte a continuación](#opciones-de-idioma).

#### Notas para teléfonos de gama baja
La carga del diccionario puede saturar teléfonos de gama baja. Al usar la versión "lite" de TT9, esto puede hacer que Android interrumpa la operación. Si la carga dura más de 30 segundos, conecte el cargador o asegúrese de que la pantalla permanezca encendida durante la carga.

Puede evitar lo anterior usando la versión "full".

#### Notas para Android 13 o superior
Por defecto, las notificaciones para las aplicaciones recién instaladas están deshabilitadas. Se recomienda habilitarlas. De esta manera, recibirá notificaciones cuando haya actualizaciones de diccionario, y una vez que elija instalarlas, TT9 mostrará el progreso de la carga. Las nuevas actualizaciones se lanzan como máximo una vez al mes, por lo que no tiene que preocuparse por recibir demasiados mensajes.

Puede habilitar las notificaciones yendo a Configuración → Idiomas y activando las Notificaciones de Diccionario.

_Si decide mantenerlas desactivadas, TT9 seguirá funcionando sin problemas, pero tendrá que gestionar los diccionarios manualmente._

## Teclas de Acceso Rápido

Todas las teclas de acceso rápido se pueden reconfigurar o deshabilitar desde Configuración → Teclado → Seleccionar Teclas de Acceso Rápido.

### Teclas de Escritura

#### Tecla de Sugerencia Anterior (Por Defecto: Flecha Izquierda del D-pad):
Seleccione la sugerencia de palabra/letra anterior.

#### Tecla de Sugerencia Siguiente (Por Defecto: Flecha Derecha del D-pad):
Seleccione la siguiente sugerencia de palabra/letra.

#### Tecla de Filtrar Sugerencias (Por Defecto: Flecha Arriba del D-pad):
_Solo en modo predictivo._

- **Una sola pulsación**: Filtra la lista de sugerencias, dejando solo las que comienzan con la palabra actual. No importa si es una palabra completa o no. Por ejemplo, escriba "remin" y presione Filtrar. Dejará solo las palabras que comienzan con "remin": "remin" en sí, "remind", "reminds", "reminded", "reminding", etc.
- **Doble pulsación**: Expande el filtro a la sugerencia completa. Por ejemplo, escriba "remin" y presione Filtrar dos veces. Primero filtrará por "remin", luego expandirá el filtro a "remind". Puede seguir expandiendo el filtro hasta llegar a la palabra más larga del diccionario.

El filtrado también es útil para escribir palabras desconocidas. Supongamos que quiere escribir "Anakin", que no está en el diccionario. Comience con "A", luego presione Filtrar para ocultar "B" y "C". Ahora presione la tecla 6. Como el filtro está activado, además de las palabras reales del diccionario, proporcionará todas las combinaciones posibles para 1+6: "A..." + "m", "n", "o". Seleccione "n" y presione Filtrar para confirmar su selección y producir "An". Ahora, al presionar la tecla 2, se proporcionará "An..." + "a", "b", y "c". Seleccione "a", y siga hasta obtener "Anakin".

Cuando el filtro está habilitado, el texto base se volverá negrita e itálico.

#### Tecla de Borrar Filtro (Por Defecto: Flecha Abajo del D-pad):
_Solo en modo predictivo._

Borrar el filtro de sugerencias, si está aplicado.

#### Flecha Central del D-pad (OK o ENTER):
- Cuando se muestran sugerencias, escribe la sugerencia actualmente seleccionada.
- De lo contrario, realiza la acción predeterminada para la aplicación actual (por ejemplo, enviar un mensaje, ir a una URL o simplemente escribir una nueva línea).

_**Nota:** Cada aplicación decide por sí misma qué hacer cuando se presiona OK y TT9 no tiene control sobre esto._

_**Nota 2:** Para enviar mensajes con OK en aplicaciones de mensajería, debes habilitar la opción "Enviar con ENTER" o una opción con un nombre similar. Si la aplicación no tiene esta opción, probablemente no sea compatible con el envío de mensajes de esta forma. En este caso, usa la aplicación KeyMapper desde [Play Store](https://play.google.com/store/apps/details?id=io.github.sds100.keymapper) o desde [F-droid](https://f-droid.org/packages/io.github.sds100.keymapper/). KeyMapper puede detectar aplicaciones de chat y simular un toque en el botón de enviar mensaje al presionar o mantener una tecla de hardware. Consulta la [guía de inicio rápido](https://docs.keymapper.club/quick-start/) para más información._

#### Tecla 0:
- **En modo 123:**
  - **Presione:** escribir "0".
  - **Mantenga presionado:** escribir caracteres especiales/matemáticos.
  - **Mantenga presionado "0", luego presione Shift (Por Defecto: mantenga presionado "0", presione "✱")**: escribir caracteres de moneda.
- **En modo ABC:**
  - **Presione:** escribir un espacio, nueva línea o caracteres especiales/matemáticos.
  - **Mantenga presionado:** escribir "0".
  - **Presione "0", luego presione Shift (Por Defecto: presione "0", "✱")**: escribir caracteres de moneda.
- **En modo Predictivo:**
  - **Presione:** escribir un espacio, nueva línea o caracteres especiales/matemáticos.
  - **Presione dos veces:** escribir el carácter asignado en la configuración de modo predictivo. (Por Defecto: ".")
  - **Mantenga presionado:** escribir "0".
  - **Presione "0", luego presione Shift (Por Defecto: presione "0", "✱")**: escribir caracteres de moneda.
- **En modo Cheonjiin (Coreano):**
  - **Presione:** escribir "ㅇ" y "ㅁ".
  - **Mantenga presionado:** escribir espacio, nueva línea, "0" o caracteres especiales/matemáticos.
  - **Mantenga presionado "0", luego presione Shift (Por Defecto: Mantenga presionado "0", presione "✱"):** escribir caracteres de moneda.

#### Tecla 1:
- **En modo 123:**
  - **Presione:** escribir "1".
  - **Mantenga presionado:** escribir caracteres de puntuación.
- **En modo ABC:**
  - **Presione:** escribir caracteres de puntuación.
  - **Mantenga presionado:** escribir "1".
- **En modo Predictivo:**
  - **Presione:** escribir caracteres de puntuación.
  - **Presione varias veces:** escribir emojis.
  - **Presione 1-1-3:** escribir emoji personalizados agregados (debe haber agregado algunos usando la [Tecla de Agregar Palabra](#tecla-de-agregar-palabra)).
  - **Mantenga presionado:** escribir "1".
- **En modo Cheonjiin (Coreano):**
  - **Presione:** escribir la vocal "ㅣ".
  - **Mantenga presionado:** escribir caracteres de puntuación.
  - **Mantene, luego presione:** escribir emojis.
  - **Mantenga presionado 1, presione 1, presione 3:** escribir emoji personalizados agregados (debe haber agregado algunos usando la [Tecla de Agregar Palabra](#tecla-de-agregar-palabra)).

#### Teclas del 2 al 9:
- **En modo 123:** escribir el número correspondiente.
- **En modo ABC y Predictivo:** escribir una letra o mantener presionado para escribir el número correspondiente.

### Teclas de Función

#### Tecla de Agregar Palabra:
Agregar una nueva palabra al diccionario para el idioma actual.

También puede agregar nuevos emojis y luego acceder a ellos presionando 1-1-3. Independientemente del idioma seleccionado, todos los emojis estarán disponibles en todos los idiomas.

#### Tecla de Borrar (Atrás, Del o Retroceso):
Simplemente elimina el texto.

Si su teléfono tiene una tecla dedicada de "Del" o "Clear", no necesita configurar nada en los Ajustes, a menos que desee tener otra tecla de retroceso. En este caso, la opción en blanco: "--" se preseleccionará automáticamente.

En teléfonos que tienen una tecla combinada de "Eliminar"/"Atrás", esa tecla se seleccionará automáticamente. Sin embargo, puede asignar la función de "Retroceso" a otra tecla, por lo que "Atrás" solo navegará hacia atrás.

_**NB:** Usar "Atrás" como retroceso no funciona en todas las aplicaciones, especialmente en Firefox, Spotify y Termux. Pueden tomar control total de la tecla y redefinir su función, lo que significa que hará lo que los autores de la aplicación pretendan. Desafortunadamente, no se puede hacer nada, porque "Atrás" juega un papel especial en Android y su uso está restringido por el sistema._

_**NB 2:** Mantener presionada la tecla "Atrás" siempre activará la acción predeterminada del sistema (es decir, mostrar la lista de aplicaciones en ejecución)._

_En estos casos, podría asignar otra tecla (todas las demás teclas son completamente utilizables), o usar el retroceso en pantalla._

#### Tecla de Modo de Entrada Siguiente (Por Defecto: presionar #):
Ciclar entre los modos de entrada (abc → Predictivo → 123).

_El modo predictivo no está disponible en campos de contraseñas._

_En campos de solo números, cambiar el modo no es posible. En tales casos, la tecla vuelve a su función predeterminada (es decir, escribir "#")._

#### Tecla de Editar Texto:
Mostrar el panel de edición de texto, que permite seleccionar, cortar, copiar y pegar texto. Puede cerrar el panel presionando la tecla "✱" de nuevo o, en la mayoría de las aplicaciones, presionando el botón Atrás. Los detalles están disponibles [a continuación](#edición-de-texto).

#### Tecla de Idioma Siguiente (Por Defecto: mantener presionado #):
Seleccione el siguiente idioma, cuando varios idiomas hayan sido habilitados desde los Ajustes.

#### Tecla de Seleccionar Teclado:
Abra el diálogo de Cambiar Teclado de Android, donde puede seleccionar entre todos los teclados instalados.

#### Tecla Shift (Por Defecto: presionar ✱):
- **Al escribir texto:** Alterna entre mayúsculas y minúsculas.
- **Al escribir caracteres especiales con la tecla 0:** Muestra el siguiente grupo de caracteres.

#### Tecla de Mostrar Ajustes:
Abra la pantalla de configuración de Ajustes. Aquí puede elegir los idiomas para escribir, configurar las teclas de acceso rápido del teclado, cambiar la apariencia de la aplicación o mejorar la compatibilidad con su teléfono.

#### Tecla de Entrada por Voz:
Active la entrada por voz en teléfonos que lo soporten. Consulte [a continuación](#entrada-por-voz) para obtener más información.

#### Tecla de Lista de Comandos / también conocida como Paleta de Comandos / (Por Defecto: mantener presionado ✱):
Mostrar una lista de todos los comandos (o funciones).

Muchos teléfonos tienen solo dos o tres botones "libres" que se pueden usar como teclas de acceso rápido. Pero T9 Tradicional tiene muchas más funciones, lo que significa que simplemente no hay espacio para todas en el teclado. La Paleta de Comandos resuelve este problema. Permite invocar las funciones adicionales (o comandos) usando combinaciones de teclas.

A continuación se muestra una lista de los posibles comandos:
- **Mostrar la pantalla de Ajustes (Combinación por Defecto: mantener presionado ✱, tecla 1).** Igual que presionar [Mostrar Ajustes](#tecla-de-mostrar-ajustes).
- **Agregar una palabra (Combinación por Defecto: mantener presionado ✱, tecla 2).** Igual que presionar [Agregar Palabra](#tecla-de-agregar-palabra).
- **Entrada por voz (Combinación por Defecto: mantener presionado ✱, tecla 3).** Igual que presionar [Entrada por Voz](#tecla-de-entrada-por-voz).
- **Editar Texto (Combinación por Defecto: mantener presionado ✱, tecla 5).** Igual que presionar [Editar Texto](#tecla-de-editar-texto).
- **Seleccionar un teclado diferente (Combinación por Defecto: mantener presionado ✱, tecla 8).** Igual que presionar [Seleccionar Teclado](#tecla-de-seleccionar-teclado).

_Esta tecla no hace nada cuando el diseño de pantalla está configurado en "Teclado Virtual" porque todas las teclas para todas las funciones posibles ya están disponibles en la pantalla._

## Entrada por Voz
La función de entrada por voz permite la conversión de voz a texto, similar a Gboard. Como todos los demás teclados, T9 Tradicional no realiza el reconocimiento de voz por sí mismo, sino que solicita a tu teléfono que lo haga.

_El botón de Entrada por Voz está oculto en los dispositivos que no la soportan._

### Dispositivos Compatibles
En dispositivos con Servicios de Google, utilizará la infraestructura de Google Cloud para convertir tus palabras en texto. Debes conectarte a una red Wi-Fi o habilitar datos móviles para que este método funcione.

En dispositivos sin Google, si el dispositivo tiene una aplicación de asistente de voz o el teclado nativo admite entrada por voz, se utilizará lo que esté disponible para el reconocimiento de voz. Ten en cuenta que este método es considerablemente menos capaz que Google. No funcionará en un entorno ruidoso y generalmente solo reconocerá frases simples, como: "abrir calendario" o "reproducir música" y similares. La ventaja es que funcionará sin conexión.

Otros teléfonos sin Google generalmente no admiten la entrada por voz. Los teléfonos chinos no tienen capacidades de reconocimiento de voz debido a políticas de seguridad de China. En estos teléfonos, es posible habilitar el soporte de entrada por voz instalando la aplicación de Google, nombre del paquete: "com.google.android.googlequicksearchbox".

## Teclado en Pantalla
En teléfonos solo con pantalla táctil, hay un teclado en pantalla totalmente funcional disponible que se activará automáticamente. Si, por alguna razón, tu teléfono no fue detectado como táctil, habilítalo yendo a Configuración → Apariencia → Disposición en Pantalla y seleccionando "Teclado Numérico Virtual".

Si tienes tanto una pantalla táctil como un teclado físico y prefieres tener más espacio en la pantalla, desactiva las teclas de software desde Configuración → Apariencia.

También se recomienda desactivar el comportamiento especial de la tecla "Atrás" para que funcione como "Retroceso". Solo es útil para un teclado físico. Por lo general, esto también sucederá automáticamente, pero si no es así, ve a Configuración → Teclado → Seleccionar Teclas de Función → Tecla Retroceso, luego selecciona la opción "--".

### Descripción General de las Teclas Virtuales
El teclado en pantalla funciona igual que el teclado numérico de un teléfono con teclas físicas. Si una tecla tiene una sola función, tiene una etiqueta (o ícono) que indica esa función. Si la tecla tiene una función secundaria al mantenerla pulsada, tendrá dos etiquetas (o íconos).

A continuación, se describe las teclas con más de una función.

#### Tecla F2 derecha (segunda tecla desde arriba en la columna derecha)
_Solo en el modo predictivo._

- **Presionar:** Filtrar la lista de sugerencias. Consulte [arriba](#tecla-de-filtrar-sugerencias-por-defecto-flecha-arriba-del-d-pad) cómo funciona el filtrado de palabras.
- **Mantener pulsado:** Borra el filtro si está activo.

#### Tecla F3 derecha (tercera tecla desde arriba en la columna derecha)
- **Presionar:** Abre las opciones de copiar, pegar y editar texto.
- **Mantener pulsado:** Activa la entrada por voz.

#### Tecla F4 izquierda (la tecla inferior izquierda)
- **Presionar:** Cambia entre los modos de entrada (abc → Predictivo → 123).
- **Mantener pulsado:** Cambia al siguiente idioma si se han habilitado varios idiomas desde la configuración.
- **Deslizar horizontalmente:** Cambia al último teclado usado, diferente al TT9.
- **Deslizar verticalmente:** Abre el diálogo de cambio de teclado de Android, donde puede seleccionar entre todos los teclados instalados.

_La tecla mostrará un pequeño ícono de globo cuando haya habilitado más de un idioma en Configuración → Idiomas. El ícono indica que es posible cambiar el idioma manteniendo pulsada la tecla._

### Redimensionar el Panel del Teclado Mientras Escribes
En algunos casos, puede que el teclado virtual ocupe demasiado espacio en la pantalla, impidiéndote ver lo que estás escribiendo o algunos elementos de la aplicación. Si es así, puedes redimensionarlo manteniendo presionada y arrastrando la tecla de Configuración/Paleta de Comandos o arrastrando la Barra de Estado (donde se muestra el idioma actual o el modo de escritura). Cuando la altura se vuelva demasiado pequeña, el diseño cambiará automáticamente a "Teclas de Función" o "Solo lista de sugerencias". Respectivamente, al redimensionar hacia arriba, el diseño cambiará a "Teclado Virtual". También puedes tocar dos veces la barra de estado para minimizar o maximizar instantáneamente.

_Redimensionar T9 Tradicional también redimensiona la aplicación actual. Hacer ambas cosas es computacionalmente muy costoso. Puede causar parpadeos o retrasos en muchos teléfonos, incluso en los de gama alta._

### Cambiar la Altura de las Teclas
También es posible cambiar la altura de las teclas en pantalla. Para hacerlo, ve a Configuración → Apariencia → Altura de las Teclas en Pantalla y ajústalo como desees.

La configuración predeterminada del 100% es un buen equilibrio entre el tamaño útil de los botones y el espacio de pantalla ocupado. Sin embargo, si tienes dedos grandes, es posible que quieras aumentar la configuración un poco, mientras que si usas TT9 en una pantalla más grande, como una tableta, es posible que quieras reducirla.

_Si el espacio de pantalla disponible es limitado, TT9 ignorará esta configuración y reducirá su altura automáticamente, para dejar suficiente espacio para la aplicación actual._

## Edición de Texto
Desde el panel de Edición de Texto, puedes seleccionar, cortar, copiar y pegar texto, similar a lo que es posible con un teclado de computadora. Para salir de la Edición de Texto, presiona la tecla "✱", o la tecla Atrás (excepto en navegadores web, Spotify y algunas otras aplicaciones). O presiona la tecla de letras en el teclado en pantalla.

A continuación, se muestra una lista de los posibles comandos de texto:
1. Seleccionar el carácter anterior (como Shift+Izquierda en un teclado de computadora)
2. Deseleccionar todo
3. Seleccionar el siguiente carácter (como Shift+Derecha)
4. Seleccionar la palabra anterior (como Ctrl+Shift+Izquierda)
5. Seleccionar todo
6. Seleccionar la siguiente palabra (como Ctrl+Shift+Derecha)
7. Cortar
8. Copiar
9. Pegar

Para facilitar la edición, las teclas de retroceso, espacio y OK también están activas.

## Pantalla de Configuración
En la pantalla de Configuración, puedes elegir los idiomas para escribir, configurar las teclas rápidas del teclado, cambiar la apariencia de la aplicación o mejorar la compatibilidad con tu teléfono.

### ¿Cómo acceder a la Configuración?

#### Método 1
Haz clic en el ícono del lanzador de T9 Tradicional.

#### Método 2 (usando pantalla táctil)
- Toca en un campo de texto o número para activar TT9.
- Usa el botón de engranaje en pantalla.

#### Método 3 (usando un teclado físico)
- Empieza a escribir en un campo de texto o número para activar TT9.
- Abre la lista de comandos usando el botón de herramientas en pantalla o presionando la tecla asignada [Por Defecto: Mantener presionado ✱].
- Presiona la tecla 2.

### Navegando en la Configuración
Si tienes un dispositivo con teclado físico, hay dos formas de navegar en la Configuración.

1. Usa las teclas Arriba/Abajo para desplazarte y OK para abrir o activar una opción.
2. Presiona las teclas del 1 al 9 para seleccionar la opción respectiva y presiona dos veces para abrir/activar. El doble toque funcionará sin importar dónde estés en la pantalla. Por ejemplo, incluso si estás en la parte superior, presionar dos veces la tecla 3 activará la tercera opción. Finalmente, la tecla 0 es un atajo conveniente para desplazarte hasta el final, pero no abre la última opción.

### Opciones de idioma

#### Cargar un diccionario
Después de habilitar uno o más idiomas nuevos, debes cargar los diccionarios respectivos para el Modo Predictivo. Una vez cargado un diccionario, permanecerá allí hasta que utilices una de las opciones de "eliminar". Esto significa que puedes habilitar y deshabilitar idiomas sin tener que recargar sus diccionarios cada vez. Solo hazlo una vez, solo la primera vez.

También significa que si necesitas comenzar a usar el idioma X, puedes deshabilitar de manera segura todos los demás idiomas, cargar solo el diccionario X (¡y ahorrar tiempo!), y luego volver a habilitar todos los idiomas que usabas antes.

Ten en cuenta que recargar un diccionario restablecerá la popularidad de las sugerencias a los valores predeterminados de fábrica. Sin embargo, no debería ser motivo de preocupación. En la mayoría de los casos, verás poca o ninguna diferencia en el orden de las sugerencias, a menos que uses palabras inusuales con frecuencia.

#### Carga automática de diccionarios

Si omites o te olvidas de cargar un diccionario desde la pantalla de Configuración, se cargará automáticamente más tarde, cuando vayas a una aplicación donde puedas escribir y cambies al Modo Predictivo. Se te pedirá que esperes hasta que termine y después de eso, podrás comenzar a escribir de inmediato.

Si eliminas uno o más diccionarios, NO se recargarán automáticamente. Tendrás que hacerlo manualmente. Solo se cargarán automáticamente los diccionarios de los idiomas recién habilitados.

#### Eliminar un diccionario
Si has dejado de usar los idiomas X o Y, podrías deshabilitarlos y también usar "Eliminar no seleccionados" para liberar algo de espacio de almacenamiento.

Para eliminar todo, independientemente de la selección, utiliza "Eliminar todo".

En todos los casos, tus palabras agregadas de forma personalizada se preservarán y se restaurarán una vez que recargues el diccionario respectivo.

#### Palabras añadidas
La opción "Exportar" te permite exportar todas las palabras añadidas, para todos los idiomas, incluidos los emoji añadidos, a un archivo CSV. Luego, puedes usar el archivo CSV para mejorar Traditional T9. Ve a GitHub y comparte las palabras en un [nuevo issue](https://github.com/sspanak/tt9/issues) o [pull request](https://github.com/sspanak/tt9/pulls). Después de ser revisadas y aprobadas, se incluirán en la próxima versión.

Con "Importar", puedes importar un CSV exportado previamente. Sin embargo, hay algunas restricciones:
- Solo puedes importar palabras que consistan en letras. No se permiten apóstrofes, guiones, otras puntuaciones o caracteres especiales.
- No se permiten emojis.
- Un archivo CSV puede contener un máximo de 250 palabras.
- Puedes importar hasta 1000 palabras, lo que significa que puedes importar como máximo 4 archivos x 250 palabras. Más allá de ese límite, aún puedes agregar palabras mientras escribes.

Con la opción "Eliminar", puedes buscar y eliminar palabras mal escritas u otras que no deseas en el diccionario.

### Opciones de compatibilidad
Para varias aplicaciones o dispositivos, es posible habilitar opciones especiales que harán que Traditional T9 funcione mejor con ellos. Puedes encontrarlas al final de cada pantalla de configuración, en la sección Compatibilidad.

#### Método alternativo de desplazamiento de sugerencias
_En: Configuración → Apariencia._

En algunos dispositivos, en el Modo Predictivo, es posible que no puedas desplazarte hasta el final de la lista o que necesites desplazarte hacia atrás y hacia adelante varias veces hasta que aparezca la última sugerencia. El problema ocurre a veces en Android 9 o anterior. Habilita la opción si experimentas este problema.

#### Siempre en la parte superior
_En: Configuración → Apariencia._

En algunos teléfonos, especialmente Sonim XP3plus (XP3900), Traditional T9 puede no aparecer cuando comienzas a escribir o puede estar parcialmente cubierto por las teclas táctiles. En otros casos, puede haber barras blancas a su alrededor. El problema puede ocurrir en una aplicación en particular o en todas ellas. Para evitarlo, habilita la opción "Siempre en la parte superior".

#### Protección contra repetición de teclas
_En: Configuración → Teclado._

Los teléfonos CAT S22 Flip y Qin F21 son conocidos por sus teclados de baja calidad, que se degradan rápidamente con el tiempo y comienzan a registrar múltiples clics por una sola pulsación de tecla. Es posible que notes esto al escribir o al navegar por los menús del teléfono.

Para los teléfonos CAT, la configuración recomendada es de 50-75 ms. Para el Qin F21, prueba con 20-30 ms. Si aún experimentas el problema, aumenta un poco el valor, pero en general intenta mantenerlo lo más bajo posible.

_**Nota:** Cuanto mayor sea el valor que configures, más lento tendrás que escribir. TT9 ignorará las pulsaciones de teclas muy rápidas._

_**Nota 2:** Además de lo anterior, los teléfonos Qin también pueden fallar al detectar pulsaciones largas. Desafortunadamente, en este caso, no se puede hacer nada._

#### Los paneles de stickers y emoji de Telegram/Snapchat no se abren
Esto ocurre si estás utilizando uno de los diseños de tamaño pequeño. Actualmente, no hay una solución permanente, pero puedes utilizar el siguiente método alternativo:
- Ve a Configuración → Apariencia y habilita Teclado numérico en pantalla.
- Vuelve al chat y haz clic en el botón de emoji o stickers. Ahora aparecerán.
- Puedes volver a la configuración y deshabilitar el teclado numérico en pantalla. Los paneles de emoji y stickers seguirán siendo accesibles hasta que reinicies la aplicación o el teléfono.

#### Traditional T9 no aparece inmediatamente en algunas aplicaciones
Si has abierto una aplicación donde puedes escribir, pero TT9 no aparece automáticamente, solo comienza a escribir y lo hará. Alternativamente, presionar las teclas de acceso rápido para cambiar [el modo de entrada](#tecla-de-modo-de-entrada-siguiente-por-defecto-presionar) o el [idioma](#tecla-de-idioma-siguiente-por-defecto-mantener-presionado) también puede hacer aparecer TT9, cuando esté oculto.

En algunos dispositivos, TT9 puede permanecer invisible, sin importar lo que hagas. En esos casos, debes habilitar [Siempre en la parte superior](#siempre-en-la-parte-superior).

**Explicación larga.** La razón de este problema es que Android está diseñado principalmente para dispositivos con pantalla táctil. Por lo tanto, espera que toques el campo de texto/número para mostrar el teclado. Es posible hacer que TT9 aparezca sin esta confirmación, pero entonces, en algunos casos, Android olvidará ocultarlo cuando deba hacerlo. Por ejemplo, puede permanecer visible después de marcar un número de teléfono o después de enviar texto en un campo de búsqueda.

Por estas razones, para cumplir con los estándares esperados de Android, el control está en tus manos. Solo presiona una tecla para "tocar" la pantalla y sigue escribiendo.

#### En el Qin F21 Pro, mantener presionadas las teclas 2 o 8 sube o baja el volumen en lugar de escribir un número
Para mitigar este problema, ve a Configuración → Apariencia, y habilita "Icono de estado". TT9 debería detectar Qin F21 y habilitar la configuración automáticamente, pero en caso de que la detección automática falle o hayas deshabilitado el icono por alguna razón, debes tenerlo habilitado para que todas las teclas funcionen correctamente.

**Explicación larga.** Qin F21 Pro (y posiblemente F22 también), tiene una aplicación de teclas rápidas que permite asignar funciones de subir y bajar volumen a las teclas numéricas. Por defecto, el administrador de teclas rápidas está habilitado, y mantener presionada la tecla 2 aumenta el volumen, mantener presionada la tecla 8 lo disminuye. Sin embargo, cuando no hay icono de estado, el administrador asume que no hay un teclado activo y ajusta el volumen en lugar de permitir que Traditional T9 maneje la tecla y escriba un número. Por lo tanto, habilitar el icono simplemente evita el administrador de teclas rápidas y todo funciona bien.

#### Problemas generales en los teléfonos Xiaomi
Xiaomi ha introducido varios permisos no estándar en sus teléfonos que impiden que el teclado virtual en pantalla de Traditional T9 funcione correctamente. Más precisamente, las teclas "Mostrar Configuración" y "Agregar Palabra" pueden no realizar sus funciones respectivas. Para solucionarlo, debes otorgar los permisos "Mostrar ventana emergente" y "Mostrar ventana emergente mientras se ejecuta en segundo plano" a TT9 desde la configuración de tu teléfono. [Esta guía](https://parental-control.flashget.com/how-to-enable-display-pop-up-windows-while-running-in-the-background-on-flashget-kids-on-xiaomi) para otra aplicación explica cómo hacerlo.

También se recomienda encarecidamente otorgar el permiso de "Notificación permanente". Esto es similar al permiso de "Notificaciones" introducido en Android 13. Consulta [arriba](#notas-para-android-13-o-superior) para obtener más información sobre por qué lo necesitas.

_Los problemas con Xiaomi se han discutido en [este issue de GitHub](https://github.com/sspanak/tt9/issues/490)._

#### La entrada por voz tarda mucho en detenerse
Es [un problema conocido](https://issuetracker.google.com/issues/158198432) en Android 10 que Google nunca solucionó. No es posible mitigar este problema en el lado de TT9. Para detener la operación de Entrada por Voz, permanece en silencio durante un par de segundos. Android apaga el micrófono automáticamente cuando no puede detectar ningún habla.

## Preguntas Frecuentes

#### ¿No puedes añadir la función X?
No.

Cada persona tiene sus propias preferencias. Algunos quieren teclas más grandes, otros un orden diferente, algunos quieren una tecla de acceso rápido para escribir ".com" y otros extrañan su antiguo teléfono o teclado. Pero por favor, entiende que hago esto voluntariamente en mi tiempo libre. Es imposible cumplir con miles de solicitudes diferentes, algunas de las cuales incluso se contradicen entre sí.

Henry Ford dijo una vez: "Puede ser de cualquier color que el cliente quiera, siempre que sea negro." De manera similar, Traditional T9 es simple, efectivo y gratuito, pero obtienes lo que ves.

#### ¿No puedes hacer que se parezca más a Sony Ericsson o Xperia, Nokia C2, Samsung u otro teclado de software?
No.

Traditional T9 no está diseñado para ser un reemplazo o una aplicación clon. Tiene un diseño único, inspirado principalmente en los Nokia 3310 y 6303i. Y aunque captura la esencia de los clásicos, ofrece una experiencia propia que no replicará exactamente ningún dispositivo.

#### ¡Deberías copiar Touchpal, es el mejor teclado del mundo!
No, no debería. Consulta los puntos anteriores.

Touchpal solía ser el mejor teclado en 2015 cuando no tenía competencia real. Sin embargo, desde entonces las cosas han cambiado. Consulta la comparación entre Traditional T9 y Touchpal:

_**Traditional T9**_
- Respeta tu privacidad.
- No contiene anuncios y es gratuito.
- Es compatible con una amplia variedad de dispositivos: teléfonos básicos y televisores con teclados físicos, así como smartphones y tablets solo con pantalla táctil.
- Ofrece un diseño T9 de 12 teclas adecuado para cada idioma.
- Mejora las sugerencias de palabras. Por ejemplo, si intentas escribir expresiones textónimas como "go in", aprenderá a no sugerir "go go" o "in in", sino la expresión significativa que tenías en mente.
- Todo lo que escribes permanece en tu teléfono. No se envía ninguna información a ningún servidor.
- Es de código abierto, lo que te permite revisar todo el código fuente y los diccionarios, contribuir al proyecto para mejorarlo (muchos usuarios han ayudado corrigiendo errores y agregando nuevos idiomas y traducciones) o incluso crear un mod según tus preferencias y visión.
- Tiene un diseño limpio y altamente legible que se integra con el sistema. No hay elementos innecesarios que distraigan, permitiéndote concentrarte en escribir.
- La velocidad de carga del diccionario es lenta.

_**Touchpal**_
- Solicita acceso a todo tu dispositivo y contactos de manera agresiva; escribe archivos aleatorios en diferentes lugares; finalmente, fue prohibido en la Play Store porque actuaba como un virus.
- Está lleno de anuncios.
- Solo es compatible con dispositivos con pantalla táctil.
- No es un teclado T9 real. Solo ofrece un diseño T9 en algunos idiomas. Además, algunos diseños son incorrectos (por ejemplo, en búlgaro falta una letra y algunas están intercambiadas entre la tecla 8 y la tecla 9).
- Al escribir textónimos seguidos, solo sugiere la última palabra que seleccionaste. Por ejemplo, al intentar escribir "go in", mostrará "go go" o "in in".
- Las sugerencias basadas en la nube podrían mejorar la precisión. Sin embargo, para que esto funcione, tú y todos los demás usuarios deben enviar todo lo que escriben a los servidores de Touchpal para su procesamiento.
- Código cerrado. No hay forma de comprobar qué hace en segundo plano.
- Incluye muchos temas, colores, GIFs y otras distracciones que no tienen relación con la escritura.
- La velocidad de carga del diccionario es rápida. Touchpal gana en este aspecto.

Si no estás de acuerdo o quieres explicar tu punto de vista, únete a [la discusión abierta](https://github.com/sspanak/tt9/issues/647) en GitHub. Solo recuerda ser respetuoso con los demás. No se tolerarán publicaciones de odio.


#### Necesito usar un diseño QWERTY (solo dispositivos con pantalla táctil)
Traditional T9 es un teclado T9 y, como tal, no proporciona un diseño similar a QWERTY.

Si aún estás aprendiendo a usar T9 y necesitas cambiar de vez en cuando, o encuentras más conveniente escribir nuevas palabras usando QWERTY, desliza hacia la tecla F4 izquierda para cambiar a un teclado diferente. Consulta la [visión general de teclas virtuales](#descripción-general-de-las-teclas-virtuales) para obtener más información.

La mayoría de los otros teclados permiten cambiar de nuevo a Traditional T9 manteniendo presionada la barra espaciadora o la tecla de "cambiar idioma". Consulta el respectivo readme o manual para más información.

#### No puedo cambiar el idioma en un teléfono con pantalla táctil
Primero, asegúrese de haber habilitado todos los idiomas deseados desde Configuración → Idiomas. Luego mantenga pulsada la [tecla izquierda F4](#tecla-f4-izquierda-la-tecla-inferior-izquierda) para cambiar el idioma.