/*
 * Copyright (C) 2007-2010 Júlio Vilmar Gesser.
 * Copyright (C) 2011, 2013-2021 The JavaParser Team.
 *
 * This file is part of JavaParser.
 *
 * JavaParser can be used either under the terms of
 * a) the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * b) the terms of the Apache License
 *
 * You should have received a copy of both licenses in LICENCE.LGPL and
 * LICENCE.APACHE. Please refer to those files for details.
 *
 * JavaParser is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 */

package com.github.javaparser.symbolsolver.javassistmodel;

import com.github.javaparser.ast.Node;
import com.github.javaparser.resolution.declarations.AssociableToAST;
import com.github.javaparser.resolution.declarations.ResolvedAnnotationDeclarationTest;
import com.github.javaparser.symbolsolver.logic.AbstractTypeDeclaration;
import com.github.javaparser.symbolsolver.logic.AbstractTypeDeclarationTest;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class JavassistAnnotationDeclarationTest extends AbstractTypeDeclarationTest implements ResolvedAnnotationDeclarationTest {

    @Override
    public JavassistAnnotationDeclaration createValue() {
        try {
            TypeSolver typeSolver = new ReflectionTypeSolver();
            CtClass clazz = ClassPool.getDefault().getCtClass("java.lang.Override");
            return new JavassistAnnotationDeclaration(clazz, typeSolver);
        } catch (NotFoundException e) {
            throw new RuntimeException("Unexpected error.", e);
        }
    }

    @Override
    public Optional<Node> getWrappedDeclaration(AssociableToAST associableToAST) {
        return Optional.empty();
    }

    @Override
    public boolean isFunctionalInterface(AbstractTypeDeclaration typeDeclaration) {
        return false;
    }

    @Disabled(value = "This feature is not yet implemented. See https://github.com/javaparser/javaparser/issues/1841")
    @Test
    @Override
    public void containerTypeCantBeNull() {
        super.containerTypeCantBeNull();
    }

    @Disabled(value = "This feature is not yet implemented. See https://github.com/javaparser/javaparser/issues/1837")
    @Test
    @Override
    public void getAllFieldsCantBeNull() {
        super.getAllFieldsCantBeNull();
    }

    @Disabled(value = "This feature is not yet implemented. See https://github.com/javaparser/javaparser/issues/1838")
    @Test
    @Override
    public void getDeclaredMethodsCantBeNull() {
        super.getDeclaredMethodsCantBeNull();
    }

}
