# Apartments

Seen on [Google Coding Interview With A Normal Software Engineer](https://www.youtube.com/watch?v=rw4s4M3hFfs&t=1030) by [Clément Mihailescu](https://www.youtube.com/channel/UCaO6VoaYJv4kS-TQO_M-N_g) and featuring (Keerti Purswani)[https://www.youtube.com/c/KeertiPurswani].

## Problem Description

Imagine that you are about to move to a new location, and you want to find an apartment that you want to live in. Imagine that you have one street which you can imagine is on a single line. At each block in this line there is an apartment that you might want to live in.

You want to make sure that the apartment you live in is really good for you. You will determine this by checking if the candidate apartment is close to a building that is important to you e.g. is it close to a gym/office/supermarket/school.

You want to find an apartment that would minimize the farthest distance that you would have to walk to in order to get to the buildings that matter to you.

### Input

1. A list of blocks and their respective amenities

Blocks = [
  {
    "gym": false,
    "school": true,
    "store": false
  },
  {
    "gym": true,
    "school": false,
    "store": false
  },
  {
    "gym": true,
    "school": true,
    "store": false
  },
  {
    "gym": false,
    "school": true,
    "store": false
  },
  {
    "gym": false,
    "school": true,
    "store": true
  }
]

2. A list of requirements comprised of the buildings that matter to you

Reqs = [ "gym", "school", "store" ]

### Output

For the sample input above, the expected output would be "3", the block in the 3rd index is closest to all the buildings you want.

### Clarifications Requested in Video

+ *Can the buildings only be gym, school, and store*? There can be any number of buildings, but every block will contain information about all buildings i.e. you won't "discover" new buildings as you traverse the list of blocks.
+ *Will the input are valid? Do I need to check if all buildings are present?* You can assume the input is valid