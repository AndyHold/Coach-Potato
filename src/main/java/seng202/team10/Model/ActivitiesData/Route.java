package seng202.team10.Model.ActivitiesData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by brad on 9/09/16.
 * route of points for mapping purposes
 * material used from provided tutorials
 */
public class Route {
    private List<Position> route = new ArrayList<>();

    public Route(Position ...points) {
        Collections.addAll(route, points);
    }
    public void addPosition(Position position) {
        this.route.add(position);
    }

    public List<Position> getRoute() {
        return route;
    }

    public String toJSONArray() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        route.forEach(pos -> stringBuilder.append(
                String.format("{lat: %f, lng: %f}, ", pos.getLatitude(), pos.getLongitude())));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}