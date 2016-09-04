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

class JBakeExtension {

    String version = '2.4.0'
    String pegdownVersion = '1.6.0'
    String freemarkerVersion = '2.3.20'
    String asciidoctorjVersion = '1.5.4.1'
    String srcDirName = 'src/jbake'
    String destDirName = 'jbake'
    boolean clearCache = false
    Map<String, Object> configuration = [:]

}
