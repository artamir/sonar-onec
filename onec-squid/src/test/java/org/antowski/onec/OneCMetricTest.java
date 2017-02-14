/*
 * SonarQube 1C:Enterprise 7.7 Plugin
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

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OneCMetricTest {

    @Test
    public void test() {
        assertThat(OneCMetric.values()).hasSize(3);

        for (OneCMetric metric : OneCMetric.values()) {
            assertThat(metric.getName()).isEqualTo(metric.name());
            assertThat(metric.isCalculatedMetric()).isFalse();
            assertThat(metric.aggregateIfThereIsAlreadyAValue()).isTrue();
            assertThat(metric.isThereAggregationFormula()).isTrue();
            assertThat(metric.getCalculatedMetricFormula()).isNull();
        }
    }

}
