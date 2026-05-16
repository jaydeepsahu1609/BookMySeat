### APIs

#### Query-Service

**1. Show all venues in a city**
*   **Endpoint**: `/api/v1/query/venues`
*   **Method**: `GET`
*   **Query Parameters**:
    *   `city` (string, required): The name of the city.
*   **Response**: `200 OK`
```json
[
  {
    "id": 1,
    "title": "PVR Cinemas",
    "address": "Koramangala, Bangalore",
    "city": "Bangalore"
  },
  {
    "id": 2,
    "title": "Inox",
    "address": "MG Road, Bangalore",
    "city": "Bangalore"
  }
]
```

**2. Show all events in a city**
*   **Endpoint**: `/api/v1/query/events`
*   **Method**: `GET`
*   **Query Parameters**:
    *   `city` (string, required): The name of the city.
*   **Response**: `200 OK`
```json
[
  {
    "id": 101,
    "title": "Inception Re-release",
    "description": "A thief who steals corporate secrets through the use of dream-sharing technology...",
    "category": 1,
    "ageRating": 13,
    "durationMinutes": 148,
    "releaseDate": "2026-07-15"
  },
  {
    "id": 102,
    "title": "Coldplay Concert",
    "description": "Live performance by Coldplay.",
    "category": 2,
    "ageRating": 18,
    "durationMinutes": 180,
    "releaseDate": "2026-08-20"
  }
]
```

**3. Show all events at a specific venue**
*   **Endpoint**: `/api/v1/query/venues/{venueId}/events`
*   **Method**: `GET`
*   **Path Parameters**:
    *   `venueId` (integer, required): The ID of the venue.
*   **Response**: `200 OK`
```json
[
  {
    "id": 101,
    "title": "Inception Re-release",
    "category": 1,
    "durationMinutes": 148
  }
]
```

**4. Show all shows for an event at a venue**
*   **Endpoint**: `/api/v1/query/venues/{venueId}/events/{eventId}/shows`
*   **Method**: `GET`
*   **Path Parameters**:
    *   `venueId` (integer, required): The ID of the venue.
    *   `eventId` (integer, required): The ID of the event.
*   **Response**: `200 OK`
```json
[
  {
    "id": 501,
    "startTime": "2026-10-15T18:00:00",
    "endTime": "2026-10-15T20:28:00",
    "auditorium": {
      "id": 10,
      "catalogId": 5
    }
  },
  {
    "id": 502,
    "startTime": "2026-10-15T21:30:00",
    "endTime": "2026-10-15T23:58:00",
    "auditorium": {
      "id": 12,
      "catalogId": 6
    }
  }
]
```