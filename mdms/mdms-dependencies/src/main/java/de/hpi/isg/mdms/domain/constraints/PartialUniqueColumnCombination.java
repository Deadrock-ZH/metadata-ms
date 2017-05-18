/***********************************************************************************************************************
 * Copyright (C) 2014 by Sebastian Kruse
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 **********************************************************************************************************************/
package de.hpi.isg.mdms.domain.constraints;

import de.hpi.isg.mdms.model.common.AbstractHashCodeAndEquals;
import de.hpi.isg.mdms.model.constraints.Constraint;
import de.hpi.isg.mdms.model.util.ReferenceUtils;
import org.apache.commons.lang3.Validate;

/**
 * Constraint implementation for a partial n-ary unique column combination.
 *
 * @author Sebastian Kruse
 */
public class PartialUniqueColumnCombination extends AbstractHashCodeAndEquals implements Constraint {

    private final int[] columnIds;

    private final double error, score;

    public PartialUniqueColumnCombination(final int[] columnIds, double error, double score) {
        Validate.isTrue(ReferenceUtils.isSorted(columnIds));
        this.columnIds = columnIds;
        this.error = error;
        this.score = score;
    }

    public int[] getColumnIds() {
        return this.columnIds;
    }

    @Override
    public int[] getAllTargetIds() {
        return this.columnIds;
    }

    public int getArity() {
        return this.columnIds.length;
    }

    public double getError() {
        return this.error;
    }

    public double getScore() {
        return this.score;
    }
}