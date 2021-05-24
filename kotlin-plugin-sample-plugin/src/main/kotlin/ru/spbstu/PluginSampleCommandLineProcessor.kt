/*
 * Copyright (C) 2020 Brian Norman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.spbstu

import com.google.auto.service.AutoService
import org.jetbrains.kotlin.compiler.plugin.AbstractCliOption
import org.jetbrains.kotlin.compiler.plugin.CliOption
import org.jetbrains.kotlin.compiler.plugin.CommandLineProcessor
import org.jetbrains.kotlin.config.CompilerConfiguration

@AutoService(CommandLineProcessor::class)
class PluginSampleCommandLineProcessor : CommandLineProcessor {
  override val pluginId: String = "ru.spbstu.kotlin-plugin-sample"

  override val pluginOptions: Collection<CliOption> = listOf(
    CliOption(
      optionName = "function",
      valueDescription = "function full-qualified name",
      description = "fully qualified path of function to intercept",
      required = false, // TODO required for Kotlin/JS
      allowMultipleOccurrences = true
    )
  )

  override fun processOption(
    option: AbstractCliOption,
    value: String,
    configuration: CompilerConfiguration
  ) {
    return when (option.optionName) {
      "function" -> configuration.add(KEY_FUNCTIONS, value)
      else -> error("Unexpected config option ${option.optionName}")
    }
  }
}
