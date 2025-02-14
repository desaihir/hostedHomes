package com.example.dao;

import org.springframework.jdbc.core.RowMapper;
import com.example.pojo.Listing;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListingRowMapper implements RowMapper<Listing> {

    public Listing mapRow(ResultSet rs, int rowNum) throws SQLException {
        Listing listing = new Listing();
        listing.setId(rs.getLong("id"));
        listing.setLocation(rs.getString("location"));
        listing.setListingName(rs.getString("listing_name"));
        // Map other fields as needed in future
        return listing;
    }
}
