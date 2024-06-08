# Roman Numeral Converter And Unit Converter

A comprehensive Android application combining two main functionalities: Roman numeral operations and various unit conversions. This project leverages modern Android development practices, written in Kotlin, and aims to provide a robust and user-friendly experience.

## Features

### RomanNumeralConverter

-   **Conversion**: Convert between Roman numerals and integers.
-   **Validation**: Check the validity of Roman numerals.
-   **UI/UX Design**: User-friendly interface with intuitive navigation and controls.
-   **Kotlin**: Written in Kotlin, leveraging its features for a robust and concise codebase.

### UnitConverter

-   **Unit Conversion**: Convert between various units such as length, weight, temperature, and more.
-   **Currency Conversion**: Real-time currency conversion based on the latest exchange rates.
-   **Historical Data**: Access historical conversion data.
-   **Multi-language Support**: Supports multiple languages for a global user base.

## Project Structure

The project follows the standard Android project structure, including:

-   **app**: Contains the main source code for the application, including activities, fragments, and other components.
-   **gradle**: Gradle configuration files for managing project dependencies and build processes.
-   **.gradle**: Gradle's system files.
-   **.idea**: IntelliJ IDEA settings and configurations.
-   **build.gradle.kts**: Kotlin script for configuring the build process.
-   **settings.gradle.kts**: Kotlin script for setting up the project's modules.

## Notable Code Snippets

### Roman Numeral Conversion

This snippet demonstrates how to convert an integer to a Roman numeral in Kotlin.

```kotlin
fun intToRoman(num: Int): String {
    val romanNumerals = listOf(
        Pair(1000, "M"), Pair(900, "CM"), Pair(500, "D"), Pair(400, "CD"),
        Pair(100, "C"), Pair(90, "XC"), Pair(50, "L"), Pair(40, "XL"),
        Pair(10, "X"), Pair(9, "IX"), Pair(5, "V"), Pair(4, "IV"), Pair(1, "I")
    )
    var number = num
    val result = StringBuilder()

    for ((value, symbol) in romanNumerals) {
        while (number >= value) {
            result.append(symbol)
            number -= value
        }
    }
    return result.toString()
}
``` 

### Roman Numeral Validation

This snippet shows how to validate if a given string is a valid Roman numeral.

```kotlin
fun isValidRoman(roman: String): Boolean {
    val regex = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$".toRegex()
    return roman.matches(regex)
}
```

### Unit Conversion

This snippet demonstrates a simple unit conversion function for length in Kotlin.

```kotlin
fun convertLength(value: Double, fromUnit: String, toUnit: String): Double {
    val conversionRates = mapOf(
        "meters" to 1.0,
        "kilometers" to 1000.0,
        "centimeters" to 0.01,
        "inches" to 0.0254,
        "feet" to 0.3048
    )
    val baseValue = value * (conversionRates[fromUnit] ?: error("Invalid unit"))
    return baseValue / (conversionRates[toUnit] ?: error("Invalid unit"))
}
```

### Currency Conversion

This snippet shows how to fetch real-time currency exchange rates using an API.

```kotlin
fun fetchExchangeRate(fromCurrency: String, toCurrency: String): Double {
    val apiUrl = "https://api.exchangerate-api.com/v4/latest/$fromCurrency"
    val response = khttp.get(apiUrl)
    val rates = response.jsonObject.getJSONObject("rates")
    return rates.getDouble(toCurrency)
}
```

## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

-   Android Studio
-   Gradle

### Installation

1.  Clone the repo
    
    ```sh
    git clone https://github.com/KPlanisphere/roman-numeral-unit-converter.git
    ```
    
2.  Open the project in Android Studio.
3.  Sync the Gradle files and build the project.
4.  Run the app on an emulator or a physical device.
