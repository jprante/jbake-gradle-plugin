/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.xbib.gradle

import org.xbib.gradle.plugin.Version
import spock.lang.Specification
import spock.lang.Unroll

class VersionTest extends Specification {

    def "fill by string"(){
        given:
        Version version = new Version("2.3.0")

        expect:
        version.major == 2
        version.minor == 3
        version.bugfix == 0
    }

    def "ignore bugfix if not present"(){
        given:
        Version version = new Version("2.0")

        expect:
        version.major == 2
        version.minor == 0
        version.bugfix == 0
    }


    def "should be equal"(){
        given:
        Version one = new Version("1.1.1")
        Version two = new Version("1.1.1")

        expect:
        two == one

    }

    @Unroll
    def "#versionOne should be less than #versionTwo"(){

        given:
        Version one = new Version(versionOne)
        Version two = new Version(versionTwo)

        expect:

        one < two

        where:
        versionOne | versionTwo
        "1.0.0"    | "1.0.1"
        "1.0.0"    | "1.1.0"
        "1.0.0"    | "1.1.1"
        "0.0.0"    | "0.0.1"
        "10.0.12"  | "11.11.11"
        "10.11.10" | "10.12.10"
    }

    @Unroll
    def "#versionTwo should be bigger than #versionOne"(){

        given:
        Version one = new Version(versionTwo)
        Version two = new Version(versionOne)

        expect:

        one > two

        where:
        versionOne | versionTwo
        "1.0.0"    | "1.0.1"
        "1.0.0"    | "1.1.0"
        "1.0.0"    | "1.1.1"
        "0.0.0"    | "0.0.1"
        "10.0.12"  | "11.11.11"
        "10.11.10" | "10.12.10"
    }

}
