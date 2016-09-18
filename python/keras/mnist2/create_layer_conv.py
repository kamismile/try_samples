
import sys

from keras.models import Sequential, save_model
from keras.layers.core import Dense, Activation, Flatten
from keras.layers import Convolution2D, MaxPooling2D

model_dest_file = sys.argv[1]

model = Sequential()

model.add(Convolution2D(8, 5, 5, input_shape = (1, 28, 28)))
model.add(Activation('relu'))

model.add(MaxPooling2D(pool_size = (2, 2), strides = (2, 2)))

model.add(Convolution2D(16, 5, 5))
model.add(Activation('relu'))

model.add(MaxPooling2D(pool_size = (3, 3), strides = (3, 3)))

model.add(Flatten())
model.add(Dense(10))
model.add(Activation('softmax'))

model.compile(loss = 'categorical_crossentropy', optimizer = 'adam', metrics = ['accuracy'])

save_model(model, model_dest_file)
