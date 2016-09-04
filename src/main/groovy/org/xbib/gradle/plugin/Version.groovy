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
package org.xbib.gradle.plugin

class Version implements Comparable {

    Integer major
    Integer minor
    Integer bugfix

    Version(String version) {
        def tokens = version.tokenize('.')

        this.major = (tokens.size >= 1) ? tokens.get(0).toInteger() : 0
        this.minor = (tokens.size >= 2) ? tokens.get(1)?.toInteger() : 0
        this.bugfix = (tokens.size >= 3) ? tokens.get(2)?.toInteger() : 0
    }

    @Override
    int compareTo(Object other) {

        def ret = 0

        if (this.major == other.major && this.minor == other.minor && this.bugfix == other.bugfix) {
            return 0
        }

        if (this.major <= other.major) {
            if (this.minor < other.minor) {
                ret = -1
            }
            if (this.bugfix < other.bugfix) {
                ret = -1
            }
        }

        if (this.major >= other.major) {
            if (this.minor > other.minor) {
                ret = 1
            }
            if (this.bugfix > other.bugfix) {
                ret = 1
            }
        }

        return ret

    }

}
