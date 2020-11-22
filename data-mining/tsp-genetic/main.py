# Import libraries
import random
import copy
import pprint
import math

COORDINATE_SYSTEM_LIMITS = 1000


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


def distance_between_two_points(p1, p2):
    return int(math.dist(p1, p2))


def init_distance_matrix(number_of_points, points):
    dist_matrix = []

    for i in range(number_of_points):
        row = []
        for j in range(number_of_points):
            row.append(distance_between_two_points(points[i], points[j]))
        dist_matrix.append(row)

    return dist_matrix


def main():
    
    n = int(input('Enter the number of points <= 100: '))
    print()

    # Random points
    point_indexes = [i for i in range(n)]
    points = [(random.randint(-COORDINATE_SYSTEM_LIMITS, COORDINATE_SYSTEM_LIMITS), 
               random.randint(-COORDINATE_SYSTEM_LIMITS, COORDINATE_SYSTEM_LIMITS)) for _ in range(n)]
    print('Random points in the coordinate system: ')
    print(points)
    print()

    # Calculate distances between the points
    dist_matrix = init_distance_matrix(n, points)

    # Genetic algorithm parameters
    start = random.randint(0, n)
    generations = 100
    mutation_rate = 0.01
    keep = 20

    population = create_population(dist_matrix, start, point_indexes, generations)
    state = genetic_algorithm(dist_matrix, start, population, keep, mutation_rate, generations)
    
    print('Solution: ')
    print(points[start], end='')
    for i in range(0, len(state.route)):
        print(' -> ', points[state.route[i]], end='')
    print(' -> ', points[start], end='')
    print()

    print('Total distance: ', state.distance)


if __name__ == "__main__":
    main()
