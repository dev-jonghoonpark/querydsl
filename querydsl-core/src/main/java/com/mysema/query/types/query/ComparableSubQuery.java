/*
 * Copyright (c) 2010 Mysema Ltd.
 * All rights reserved.
 *
 */
package com.mysema.query.types.query;

import com.mysema.query.QueryMetadata;
import com.mysema.query.types.SubQueryExpression;
import com.mysema.query.types.SubQueryMixin;
import com.mysema.query.types.Visitor;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.ComparableExpression;

/**
 * Single result subquery
 *
 * @author tiwe
 *
 * @param <A>
 */
public final class ComparableSubQuery<A extends Comparable<?>> extends ComparableExpression<A> implements SubQueryExpression<A>{

    private static final long serialVersionUID = -64156984110154969L;

    private final SubQueryMixin<A> subQueryMixin;

    public ComparableSubQuery(Class<A> type, QueryMetadata md) {
        super(type);
        subQueryMixin = new SubQueryMixin<A>(type, md);
    }

    @Override
    public <R,C> R accept(Visitor<R,C> v, C context) {
        return v.visit(this, context);
    }

    @Override
    public boolean equals(Object o) {
       return subQueryMixin.equals(o);
    }

    @Override
    public BooleanExpression exists() {
        return subQueryMixin.exists();
    }

    @Override
    public QueryMetadata getMetadata() {
        return subQueryMixin.getMetadata();
    }

    @Override
    public int hashCode(){
        return subQueryMixin.hashCode();
    }

    @Override
    public BooleanExpression notExists() {
        return subQueryMixin.notExists();
    }

}
