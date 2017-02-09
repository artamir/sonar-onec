/*
 * 1C:Enterprise 7.7 language plugin for SonarQube
 * Copyright (C) 2017 antowski
 * mailto:antowski AT gmail DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package org.antowski.onec;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableSet;
import com.sonar.sslr.api.GenericTokenType;
import com.sonar.sslr.api.Token;
import com.sonar.sslr.impl.Lexer;
import java.util.List;
import java.util.Set;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.sonar.sslr.test.lexer.LexerMatchers.hasComment;
import static com.sonar.sslr.test.lexer.LexerMatchers.hasToken;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class OnecLexerTest {

  private static Lexer lexer;

  @BeforeClass
  public static void init() {
    //lexer = OnecLexer.create(new PythonConfiguration(Charsets.UTF_8));
    lexer = OnecLexer.create();
  }

  @Test
  public void comments() {
    assertThat(lexer.lex("// my comment \n new line"), hasComment("// my comment "));
    assertThat(lexer.lex("// мой комментарий \n new line"), hasComment("// мой комментарий "));
    assertThat(lexer.lex("В одной строке код // и комментарий \n следующая строка"), hasComment("// и комментарий "));
    assertThat(lexer.lex("Много слешей подряд = один комментарий ////////////"), hasComment("////////////"));
  }
  
}
