package ridesupport.car.resource;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;
import ridesupport.car.model.Car;
import ridesupport.car.service.CarService;


import java.util.List;

@Path("/cars")
public class CarResource {

    ResponseBuilder response;

    @Context
    UriInfo uriInfo;

    @EJB
    CarService carService;

    @GET
    public List<Car> getAllCars(@QueryParam("first") int first, @QueryParam("maxResult") int maxResult) {
        return carService.getAllCars(first, maxResult);
    }

    @GET
    @Path("{id}")
    public Response getCarByPlates(@PathParam("id") String plateNumber) {
        Car car = carService.getCarByPlates(plateNumber);
        response = Response.status(Response.Status.OK);
        response.entity(car);
        return response.build();
    }

    @POST
    public Response createCar(Car car) {
        Car createdCar = carService.createCar(car);
        response = Response.status(Response.Status.CREATED);
        response.entity(createdCar);
        return response.build();
    }

    @PUT
    @Path("{id}")
    public Response updateCar(@PathParam("id") String plateNumber, Car car) {
        Car updatedCar = carService.updateCar(plateNumber, car);
        response = Response.status(Response.Status.OK);
        response.entity(updatedCar);
        return response.build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCar(@PathParam("id") String plateNumber) {
        String deletedCarPlate = carService.deleteCar(plateNumber);
        response = Response.status(Response.Status.OK);
        response.entity(deletedCarPlate);
        return response.build();
    }
}
