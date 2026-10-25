# Our Sour App (DSY1105 – Prueba 2)

App Android (Kotlin + Jetpack Compose + Room + CameraX/ML Kit). Frontend sin conexión al backend (Prueba 2).

## Abrir
1. Android Studio -> Open -> esta carpeta.
2. Settings > Build Tools > Gradle > **Gradle JDK = jbr-21** (no uses JDK 25).
3. Si pide actualizar AGP: "Remind me later". Instala el SDK 35 si falta.
4. Run en un emulador (API 34+).

## Cuentas demo
- cliente@oursour.cl / cliente123
- admin@oursour.cl / admin123

## QR
Imágenes en `qr-prueba/`. Formato: `OURSOUR:RECIPE:<id>` y `OURSOUR:PRODUCT:<id>`.
La pantalla de QR también permite simular la lectura escribiendo el código.

Más detalle: `Documentacion_OurSour_App.docx`.

## Arquitectura (MVVM)
```
cl.oursour.app
├── model        <- datos y reglas de negocio
│   ├── entity       tablas Room (Entities.kt)
│   ├── dao          consultas SQL (Daos.kt)
│   ├── database     AppDatabase + SeedData
│   ├── domain       constantes y modelos de dominio (RecipeMatch)
│   ├── repository   repositorios (única fuente de datos para los ViewModels)
│   └── session      SessionManager (sesión guardada)
├── view         <- Jetpack Compose (solo UI)
│   ├── theme · components · navigation
│   └── screens      admin, auth, cart, home, ingredients, profile, recipes, scanner
├── viewmodel    <- estado de cada pantalla + AppViewModelProvider
├── di           AppContainer (inyección manual de dependencias)
└── util         Hasher, QrParser, QrAnalyzer, formatos, MatchCalculator
```
