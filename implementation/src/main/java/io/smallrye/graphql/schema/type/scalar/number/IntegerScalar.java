/*
 * Copyright 2019 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.smallrye.graphql.schema.type.scalar.number;

import java.math.BigDecimal;
import java.math.BigInteger;

import graphql.Scalars;
import io.smallrye.graphql.schema.Argument;

/**
 * Scalar for Integer.
 * Based on graphql-java's Scalars.GraphQLInt
 * 
 * @author Phillip Kruger (phillip.kruger@redhat.com)
 */
public class IntegerScalar extends AbstractNumberScalar {

    public IntegerScalar() {

        super(Scalars.GraphQLInt.getName(),
                new Converter() {
                    @Override
                    public Object fromBigDecimal(BigDecimal bigDecimal) {
                        return bigDecimal.intValueExact();
                    }

                    @Override
                    public Object fromBigInteger(BigInteger bigInteger) {
                        return bigInteger.intValue();
                    }

                    @Override
                    public Object fromNumber(Number number, Argument argument) {
                        return number.intValue();
                    }

                    @Override
                    public boolean isInRange(BigInteger value) {
                        return (value.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0
                                || value.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) > 0);
                    }

                },
                Integer.class, int.class);
    }

}
