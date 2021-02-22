package me.scoretwo.fastscript.expansion.groovy

import groovy.lang.GroovyShell
import me.scoretwo.fastscript.expansion.typeengine.TypeEngineExpansion
import javax.script.ScriptEngine

/**
 * @author Score2
 * @date 2021/2/22 9:28
 *
 * @project Expansion-Groovy
 */
class GroovyExpansion: TypeEngineExpansion() {
    override val name: String = "Groovy"
    override val sign: String = "groovy"
    override val fileSuffix: String = "groovy"
    override val engine: ScriptEngine = scriptEngineManager.getEngineByName("groovy")
}