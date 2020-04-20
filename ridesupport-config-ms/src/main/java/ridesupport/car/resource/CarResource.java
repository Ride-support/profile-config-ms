package ridesupport.car.resource;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import ridesupport.car.model.Car;
import ridesupport.car.service.CarService;


import java.util.List;

@Path("/cars")
public class CarResource {

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
    public Car getCarByPlates(@PathParam("id") String plateNumber) {
        return carService.getCarByPlates(plateNumber);
    }

    @POST
    public Response createCar(Car car) {
        carService.createCar(car);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response updateCar(@PathParam("id") String plateNumber, Car car) {
        carService.updateCar(plateNumber, car);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCar(@PathParam("id") String plateNumber) {
        carService.deleteCar(plateNumber);
        return Response.status(Response.Status.OK).build();
    }
}
