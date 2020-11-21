# Import libraries
import random
import copy
# This class represent a state


class State:
    # Create a new state
    def __init__(self, route: [], distance: int = 0):
        self.route = route
        self.distance = distance
    # Compare states

    def __eq__(self, other):
        for i in range(len(self.route)):
            if(self.route[i] != other.route[i]):
                return False
        return True
    # Sort states

    def __lt__(self, other):
        return self.distance < other.distance
    # Print a state

    def __repr__(self):
        return ('({0},{1})\n'.format(self.route, self.distance))
    # Create a shallow copy

    def copy(self):
        return State(self.route, self.distance)
    # Create a deep copy

    def deepcopy(self):
        return State(copy.deepcopy(self.route), copy.deepcopy(self.distance))
    # Update distance

    def update_distance(self, matrix, home):

        # Reset distance
        self.distance = 0
        # Keep track of departing city
        from_index = home
        # Loop all cities in the current route
        for i in range(len(self.route)):
            self.distance += matrix[from_index][self.route[i]]
            from_index = self.route[i]
        # Add the distance back to home
        self.distance += matrix[from_index][home]
# This class represent a city (used when we need to delete cities)


class City:
    # Create a new city
    def __init__(self, index: int, distance: int):
        self.index = index
        self.distance = distance
    # Sort cities

    def __lt__(self, other):
        return self.distance < other.distance
# Get best solution by distance


def get_best_solution_by_distance(matrix: [], home: int):

    # Variables
    route = []
    from_index = home
    length = len(matrix) - 1
    # Loop until route is complete
    while len(route) < length:
        # Get a matrix row
        row = matrix[from_index]
        # Create a list with cities
        cities = {}
        for i in range(len(row)):
            cities[i] = City(i, row[i])
        # Remove cities that already is assigned to the route
        del cities[home]
        for i in route:
            del cities[i]
        # Sort cities
        sorted = list(cities.values())
        sorted.sort()
        # Add the city with the shortest distance
        from_index = sorted[0].index
        route.append(from_index)
    # Create a new state and update the distance
    state = State(route)
    state.update_distance(matrix, home)
    # Return a state
    return state
# Create a population


def create_population(matrix: [], home: int, city_indexes: [], size: int):
    # Create a gene pool
    gene_pool = city_indexes.copy()
    # Remove the home city
    gene_pool.pop(home)
    # Create a population
    population = []
    for i in range(size):
        # Shuffle the gene pool at random
        random.shuffle(gene_pool)
        # Create a new state and update the distance
        state = State(gene_pool[:])
        state.update_distance(matrix, home)
        # Add an individual to the population
        population.append(state)
    # Return a population
    return population
# Ordered crossover (TSP)


def crossover(matrix: [], home: int, parents: []):

    # Copy parents
    parent_1 = parents[0].deepcopy()
    parent_2 = parents[1].deepcopy()
    # Child gene parts
    part_1 = []
    part_2 = []

    # Select the genes to copy from parents
    a = int(random.random() * len(parent_1.route))
    b = int(random.random() * len(parent_2.route))
    start_gene = min(a, b)
    end_gene = max(a, b)
    # Get genes from parent 1
    for i in range(start_gene, end_gene):
        part_1.append(parent_1.route[i])

    # Get genes from parent 2
    part_2 = [int(x) for x in parent_2.route if x not in part_1]
    # Create a child
    state = State(part_1 + part_2)
    state.update_distance(matrix, home)
    # Return a child
    return state
# Mutate a solution


def mutate(matrix: [], home: int, state: State, mutation_rate: float = 0.01):

    # Create a copy of the state
    mutated_state = state.deepcopy()
    # Loop all the states in a route
    for i in range(len(mutated_state.route)):
        # Check if we should do a mutation
        if(random.random() < mutation_rate):
            # Swap two cities
            j = int(random.random() * len(state.route))
            city_1 = mutated_state.route[i]
            city_2 = mutated_state.route[j]
            mutated_state.route[i] = city_2
            mutated_state.route[j] = city_1
    # Update the distance
    mutated_state.update_distance(matrix, home)
    # Return a mutated state
    return mutated_state
# A genetic algorithm


def genetic_algorithm(matrix: [], home: int, population: [], keep: int, mutation_rate: float, generations: int):

    # Loop to create new generations
    for i in range(generations):

        # Sort the population to get the fittest individuals at the beginning
        population.sort()
        # Generate parents
        parents = []
        for j in range(1, len(population)):
            parents.append((population[j-1], population[j]))
        # Generate childrens (breed) with crossover
        children = []
        for partners in parents:
            children.append(crossover(matrix, home, partners))
        # Mutate children
        for j in range(len(children)):
            children[j] = mutate(matrix, home, children[j], mutation_rate)

        # Keep the fittest n from the population
        population = population[:keep]
        # Add children to the population
        population.extend(children)
    # Sort the population
    population.sort()
    # Return the best state
    return population[0]
# The main entry point for this module


def main():
    # Cities to travel
    cities = ['New York', 'Los Angeles', 'Chicago', 'Minneapolis', 'Denver', 'Dallas',
              'Seattle', 'Boston', 'San Francisco', 'St. Louis', 'Houston', 'Phoenix', 'Salt Lake City']
    city_indexes = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
    # Index of start location
    home = 2  # Chicago
    # Distances in miles between cities, same indexes (i, j) as in the cities array
    matrix = [[0, 2451, 713, 1018, 1631, 1374, 2408, 213, 2571, 875, 1420, 2145, 1972],
              [2451, 0, 1745, 1524, 831, 1240, 959,
                  2596, 403, 1589, 1374, 357, 579],
              [713, 1745, 0, 355, 920, 803, 1737, 851, 1858, 262, 940, 1453, 1260],
              [1018, 1524, 355, 0, 700, 862, 1395,
                  1123, 1584, 466, 1056, 1280, 987],
              [1631, 831, 920, 700, 0, 663, 1021, 1769, 949, 796, 879, 586, 371],
              [1374, 1240, 803, 862, 663, 0, 1681, 1551, 1765, 547, 225, 887, 999],
              [2408, 959, 1737, 1395, 1021, 1681, 0,
                  2493, 678, 1724, 1891, 1114, 701],
              [213, 2596, 851, 1123, 1769, 1551, 2493,
                  0, 2699, 1038, 1605, 2300, 2099],
              [2571, 403, 1858, 1584, 949, 1765, 678,
                  2699, 0, 1744, 1645, 653, 600],
              [875, 1589, 262, 466, 796, 547, 1724,
                  1038, 1744, 0, 679, 1272, 1162],
              [1420, 1374, 940, 1056, 879, 225, 1891,
                  1605, 1645, 679, 0, 1017, 1200],
              [2145, 357, 1453, 1280, 586, 887, 1114,
                  2300, 653, 1272, 1017, 0, 504],
              [1972, 579, 1260, 987, 371, 999, 701, 2099, 600, 1162, 1200, 504, 0]]
    # Get the best route by distance
    state = get_best_solution_by_distance(matrix, home)
    print('-- Best solution by distance --')
    print(cities[home], end='')
    for i in range(0, len(state.route)):
        print(' -> ' + cities[state.route[i]], end='')
    print(' -> ' + cities[home], end='')
    print('\n\nTotal distance: {0} miles'.format(state.distance))
    print()
    # Run genetic search to find a better solution
    population = create_population(matrix, home, city_indexes, 100)
    state = genetic_algorithm(matrix, home, population, 20, 0.01, 100)
    print('-- Genetic algorithm solution --')
    print(cities[home], end='')
    for i in range(0, len(state.route)):
        print(' -> ' + cities[state.route[i]], end='')
    print(' -> ' + cities[home], end='')
    print('\n\nTotal distance: {0} miles'.format(state.distance))
    print()


# Tell python to run main method
if __name__ == "__main__":
    main()
