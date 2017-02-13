/**
 *    Copyright 2016-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.dynamic.sql.where.condition;

import org.mybatis.dynamic.sql.AbstractTwoValueCondition;

public class IsBetween<T> extends AbstractTwoValueCondition<T> {

    protected IsBetween(T value1, T value2) {
        super(value1, value2);
    }
    
    @Override
    public String render(String columnName, String placeholder1, String placeholder2) {
        return columnName + " between " + placeholder1 + " and " + placeholder2; //$NON-NLS-1$ //$NON-NLS-2$
    }

    public static class Builder<T> {
        private T value1;
        
        private Builder(T value1) {
            this.value1 = value1;
        }
        
        public IsBetween<T> and(T value2) {
            return new IsBetween<>(value1, value2);
        }
        
        public static <T> Builder<T> of(T value1) {
            return new Builder<>(value1);
        }
    }
}
