'use strict';

angular.module('finaltestApp').controller('DrinkrecipeDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Drinkrecipe', 'Ingredients',
        function($scope, $stateParams, $uibModalInstance, entity, Drinkrecipe, Ingredients) {

        $scope.drinkrecipe = entity;
        $scope.ingredientss = Ingredients.query();
        $scope.load = function(id) {
            Drinkrecipe.get({id : id}, function(result) {
                $scope.drinkrecipe = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('finaltestApp:drinkrecipeUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.drinkrecipe.id != null) {
                Drinkrecipe.update($scope.drinkrecipe, onSaveSuccess, onSaveError);
            } else {
                Drinkrecipe.save($scope.drinkrecipe, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
}]);
