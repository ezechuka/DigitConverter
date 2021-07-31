# Digit2WordConverter
Digit2WordConverter - Simply returns the word interpretation of a given digit. 
The range of values currently supported is 1 - 9,999,999.

[![](https://jitpack.io/v/ezechuka/Digit2WordConverter.svg)](https://jitpack.io/#ezechuka/Digit2WordConverter)

## Dependency Project Level
     Add the JitPack repository to your build file

     Add it in your root build.gradle at the end of repositories:
       allprojects {
           repositories {
               ...
               maven { url 'https://jitpack.io' }
           }
       }
  
## Dependency App Level
    Add dependency in your app module

	  dependencies {
	        implementation 'com.github.ezechuka:DigitConverter:1.0.0'
	  }

      
## Usage
Use `DigitConverter.asWords(figure: Int)` to get the word representation of the given figure.
