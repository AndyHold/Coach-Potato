package seng202.team10.Model.ActivitiesData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class created by brad on 9/09/16.
 * route of points for mapping purposes
 * material used from provided tutorials
 */
public class Route {
    private List<Position> route = new ArrayList<>();

    /**
     * Constructor for Route Class.
     * @param points A collection of points.
     */
    public Route(Position ...points) {
        Collections.addAll(route, points);
    }

    /**
     * Method to add a position to the route class.
     * @param position The <b>Position</b> being added.
     */
    public void addPosition(Position position) {
        this.route.add(position);
    }

    /**
     * Getter for the route.
     * @return A <b>List&lt;Position&gt;</b> of the positions in the route.
     */
    public List<Position> getRoute() {
        return route;
    }

    /**
     * Converts this class to a JSON Array for use in html scripts.
     * @return A <b>JSONArray</b>.
     */
    public String toJSONArray() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        route.forEach(pos -> stringBuilder.append(
                String.format("{lat: %f, lng: %f}, ", pos.getLatitude(), pos.getLongitude())));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}