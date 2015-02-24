/*
 * Copyright (C) 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ro.pippo.core.route;

import ro.pippo.core.Application;
import ro.pippo.core.ParameterValue;
import ro.pippo.core.Request;
import ro.pippo.core.Response;
import ro.pippo.core.Session;

import java.io.File;
import java.util.Map;

/**
 * @author James Moger
 */
public interface RouteContext {

    Application getApplication();

    Request getRequest();

    Response getResponse();

    boolean hasSession();

    Session getSession();

    void recreateSession();

    void resetSession();

    void touchSession();

    void invalidateSession();

    <T> T setSession(String name, T t);

    <T> T getSession(String name);

    <T> T removeSession(String name);

    <T> T setLocal(String name, T t);

    void setLocals(Map<String, Object> locals);

    <T> T getLocal(String name);

    <T> T removeLocal(String name);

    ParameterValue getParameter(String name);

    ParameterValue getHeader(String name);

    <T> T setHeader(String name, T t);

    void flashError(String message, Object... args);

    void flashWarning(String message, Object... args);

    void flashInfo(String message, Object... args);

    void flashSuccess(String message, Object... args);

    <T> T createEntityFromParameters(Class<T> classOfT);

    <T> T createEntityFromBody(Class<T> classOfT);

    String getRequestUri();

    String getRequestMethod();

    boolean isRequestMethod(String method);

    void render(String templateName);

    void send(CharSequence content);

    void send(File file);

    void send(Object object);

    void redirect(String path);

    void next();

    void runFinallyRoutes();

    RouteContext text();

    RouteContext xml();

    RouteContext json();

    RouteContext yaml();

    RouteContext html();

    RouteContext negotiateContentType();

    RouteContext status(int code);

}