import Foundation

@objc public class AHaptic: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
