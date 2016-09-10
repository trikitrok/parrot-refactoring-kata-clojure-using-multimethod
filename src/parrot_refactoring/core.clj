(ns parrot-refactoring.core)

(def ^:private base-speed 12.0)

(defmulti speed :type)

(defmethod speed :european-parrot [_]
  base-speed)

(defmethod speed :african-parrot [{:keys [num-coconuts]}]
  (let [load-factor 9.0]
    (max 0.0 (- base-speed (* load-factor num-coconuts)))))

(defmethod speed :norwegian-blue-parrot [{:keys [nailed voltage]}]
  (if nailed
    0.0
    (min 24.0 (* voltage base-speed))))

(defmethod speed :default [_]
  (throw (Exception. "Should be unreachable!")))
