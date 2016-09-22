package com.practice.services;


import com.google.common.collect.ImmutableSet;
import com.practice.services.models.BookRequest;
import com.practice.services.models.BookResponse;
import com.practice.services.models.Error;
import com.practice.services.services.BookAccessService;
import com.sun.jersey.spi.resource.Singleton;
import com.sun.org.apache.regexp.internal.RE;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by janardhan.nellibanda on 9/21/2016.
 */
@Singleton
@Path("books")
@Named
public class BookResource {
    private static final ImmutableSet<String> REQUEST_QUERY_PARAMS = ImmutableSet.of("limit");
    private final BookAccessService bookAccessService;

    @Inject
    public BookResource(final BookAccessService bookAccessService) {
        this.bookAccessService = bookAccessService;
    }

    @GET
    @Path("getAllBooks")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAllBooks(@QueryParam("limit") String limit, @Context final UriInfo uriInfo) {

        Response response = null;

        try {
            for (String paramName : uriInfo.getQueryParameters().keySet()) {
                if (!REQUEST_QUERY_PARAMS.contains(paramName)) {
                    throw new Exception(paramName + " is not a valid parameter");
                }
            }
            response = Response.status(Response.Status.OK).entity(bookAccessService.getAllBooks(limit)).build();

        } catch (Exception e) {
            response = getErrorResponse(e);
        }

        return response;
    }

    @POST
    @Path("addBook")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response addBooks(BookRequest bookRequest,
                             @QueryParam("limit") String limit) {

        Response response = null;

        try {

            response = Response.status(Response.Status.OK).entity(bookAccessService.addBooks(bookRequest)).build();

        } catch (Exception e) {
            response = getErrorResponse(e);

        }

        return response;
    }

    @POST
    @Path("updateBook")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response updateBooks(BookRequest bookRequest,
                                @QueryParam("limit") String limit) {

        Response response = null;

        try {

            response = Response.status(Response.Status.OK).entity(bookAccessService.updateBooks(bookRequest)).build();

        } catch (Exception e) {
            response = getErrorResponse(e);
        }

        return response;
    }

    @DELETE
    @Path("deleteBook")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response deleteBooks(BookRequest bookRequest,
                                @QueryParam("limit") String limit) {

        Response response = null;

        try {

            response = Response.status(Response.Status.OK).entity(bookAccessService.deleteBooks(bookRequest)).build();

        } catch (Exception e) {
            response = getErrorResponse(e);
        }

        return response;
    }


    private Response getErrorResponse(Exception e) {
        Response response;BookResponse bookResponse = new BookResponse();
        Error error = new Error();
        error.setMessage(e.getMessage());
        bookResponse.setError(error);
        response = Response.status(Response.Status.BAD_REQUEST).entity(bookResponse).build();
        return response;
    }

}
