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
package org.mybatis.dynamic.sql.where.render;

import java.util.HashMap;
import java.util.Map;

public class FragmentAndParameters {
    
    private String fragment;
    private Map<String, Object> parameters = new HashMap<>();
    
    private FragmentAndParameters() {
        super();
    }
    
    public String fragment() {
        return fragment;
    }
    
    public Map<String, Object> parameters() {
        return parameters;
    }
    
    public FragmentAndParameters merge(FragmentAndParameters other, String delimiter) {
        return new Builder(fragment + delimiter + other.fragment)
                .withParameters(parameters)
                .withParameters(other.parameters)
                .build();
    }

    public static class Builder {
        private FragmentAndParameters fragmentAndParameters = new FragmentAndParameters();
        
        public Builder(String fragment) {
            fragmentAndParameters.fragment = fragment;
        }
        
        public Builder withParameter(String key, Object value) {
            fragmentAndParameters.parameters.put(key, value);
            return this;
        }
        
        public Builder withParameters(Map<String, Object> parameters) {
            fragmentAndParameters.parameters.putAll(parameters);
            return this;
        }
        
        public FragmentAndParameters build() {
            return fragmentAndParameters;
        }
    }
}
