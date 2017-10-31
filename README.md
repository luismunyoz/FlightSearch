# Flight Search App [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

This project demonstrates the use of _MVP architecture pattern_ on an Android Application developed in **Kotlin**. It uses _Repository pattern_ as well as **Dagger** for _Dependency Injection_. 

This application connects to [Skyscanner API](https://partners.skyscanner.net/affiliates/travel-apis/) to query flight results.

It consists of 3 screens: 
* Search screen (first screen)
![Search screen](/art/init.png)
* Search locations / places screen - We search for airports here
![Search places screen](/art/search_place.png)
* Results screen with flights information.
![Results screen](/art/results.png)

### At a glance

* Kotlin
* MVP (_Model, View, Presenter_)
* Dagger
* EventBus
* Interactor executor
* Repository Pattern
* Retrofit
* Glide
* Databinding

### Inspiration

* [Google's Android Blueprints](https://github.com/googlesamples/android-architecture)
* [@antoniolg Bandhook Kotlin](https://github.com/antoniolg/Bandhook-Kotlin)

# License

    Copyright 2017 Luis Muñoz

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.